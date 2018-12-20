package algorithms.search;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2018/12/20 下午3:36
 */
public class SeparateChainingHashST<K extends Comparable<K>, V> {
    int M; //散列表大小
    SequentialSearchST<K, V>[] sequentialSearchSTS;

    SeparateChainingHashST(int m) {
        M = m;
        sequentialSearchSTS = new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            sequentialSearchSTS[i] = new SequentialSearchST<>();
        }
    }

    void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = hash(key);
        SequentialSearchST<K, V> sequentialSearchST = sequentialSearchSTS[hash];
        sequentialSearchST.put(key, value);
    }

    V get(K key) {
        if (key == null) {
            return null;
        }
        int hash = hash(key);
        SequentialSearchST<K, V> sequentialSearchST = sequentialSearchSTS[hash];
        return sequentialSearchST.get(key);
    }

    void delete(K key) {
        if (key == null) {
            return;
        }
        int hash = hash(key);
        SequentialSearchST<K, V> sequentialSearchST = sequentialSearchSTS[hash];
        sequentialSearchST.delete(key);
    }

    int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }


    public static void main(String[] args) {
        SeparateChainingHashST<String, String> stringStringSeparateChainingHashST = new SeparateChainingHashST<>(10);
        stringStringSeparateChainingHashST.put("hello", "world");
        stringStringSeparateChainingHashST.put("java", "kotlin");
        Assert.check(stringStringSeparateChainingHashST.get("java").equals("kotlin"));
        Assert.check(stringStringSeparateChainingHashST.get("hello").equals("world"));
        stringStringSeparateChainingHashST.delete("hello");
        Assert.checkNull(stringStringSeparateChainingHashST.get("hello"));
    }
}
