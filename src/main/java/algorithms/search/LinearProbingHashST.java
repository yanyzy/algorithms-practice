package algorithms.search;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2018/12/23 下午3:11
 */
public class LinearProbingHashST<K, V> {

    int M;
    int N;
    K[] keys;
    V[] values;

    public LinearProbingHashST(int cap) {
        M = cap;
        N = 0;
        this.keys = (K[]) new Object[M];
        this.values = (V[]) new Object[M];
    }

    int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    void put(K key, V value) {
        if (N > M / 2) {
            resize(M * 2);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    V get(K key) {
        if (key == null) {
            return null;
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    void delete(K key) {
        if (key == null) {
            return;
        }
        if (!contains(key)) {
            return;
        }

        int i = hash(key);
        while (!keys[i].equals(key)) {
            i = (i + 1) % M;
        }

        keys[i] = null;
        values[i] = null;
        N--;

        i++;
        while (keys[i] != null) {
            K newK = keys[i];
            V newV = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(newK, newV);
            i = (i + 1) % M;
        }

        if (N > 0 && N < M / 8) {
            resize(M / 2);
        }
    }

    boolean contains(K key) {
        if (key == null) {
            return false;
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    void resize(int cap) {
        LinearProbingHashST<K, V> st = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                st.put(keys[i], values[i]);
            }
        }
        keys = st.keys;
        values = st.values;
        M = st.M;
    }

    public static void main(String[] args) {
        LinearProbingHashST<String, String> linearProbingHashST = new LinearProbingHashST<>(10);
        linearProbingHashST.put("test1", "test1");
        linearProbingHashST.put("test2", "test2");
        Assert.check(linearProbingHashST.N == 2);
        Assert.check(linearProbingHashST.get("test1").equals("test1"));
        linearProbingHashST.delete("test1");
        Assert.checkNull(linearProbingHashST.get("test1"));
        for (int i = 0; i < 20; i++) {
            linearProbingHashST.put(String.valueOf(i), String.valueOf(i));
        }
        Assert.check(linearProbingHashST.get("18").equals("18"));
        for (int i = 0; i < 10; i++) {
            linearProbingHashST.delete(String.valueOf(i));
            Assert.checkNull(linearProbingHashST.get(String.valueOf(i)));
        }
    }
}
