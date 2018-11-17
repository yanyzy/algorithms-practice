import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhyee
 * @date 2018/11/17 下午7:18
 */
public class ST<K, V> {
    List<Object> keys;
    List<Object> vals;
    int size;

    ST() {
        this.keys = new ArrayList<>();
        this.vals = new ArrayList<>();
        this.size = 0;
    }

    void put(K key, V val) {
        if (key == null) {
            return;
        }
        boolean b = false;
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                vals.set(i, val);
                b = true;
            }
        }

        if (!b) {
            size++;
            keys.add(key);
            vals.add(val);
        }
    }

    V get(K key) {
        if (key == null) {
            return null;
        }
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                return (V) vals.get(i);
            }
        }
        return null;
    }

    void delete(K key) {
        if (key == null) {
            return;
        }
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                keys.remove(i);
                vals.remove(i);
                size--;
            }
        }
    }

    boolean contains(K key) {
        for (Object key1 : keys) {
            if (key1.equals(key)) {
                return true;
            }
        }
        return false;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    Iterable<K> keys() {
        return (Iterable<K>) keys;
    }

    public static void main(String[] args) {
        ST<String, String> st = new ST<>();
        for (int i = 10; i < 1000; i++) {
            st.put("jack" + org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(i), 4, "0"), "tom" + i);
        }

        for (int i = 2000; i > 1500; i--) {
            st.put("jack" + org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(i), 4, "0"), "tom" + i);
        }

        for (int i = 10; i > 0; i--) {
            st.put("jack" + org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(i), 4, "0"), "tom" + i);
        }

        Assert.check(st.contains("jack0012"));
        Assert.check(st.get("jack0012").equals("tom12"));
        st.put("jack0012", "tom123");
        Assert.check(st.get("jack0012").equals("tom123"));
        Assert.check(8 != st.size());
        st.delete("jack0012");
        Assert.check(!st.contains("jack0012"));
    }
}
