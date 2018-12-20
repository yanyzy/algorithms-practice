package algorithms.search;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhyee
 * @date 2018/11/10 下午3:03
 */
public class ST<K extends Comparable<K>, V> {

    private List<Object> keys;
    private List<Object> values;
    private int size;

    public ST(int size) {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        this.size = 0;
    }

    public void put(K key, V value) {
        if (size == 0) {
            keys.add(key);
            values.add(value);
            size++;
        }
        for (int i = 0; i < keys.size(); i++) {
            if (key.compareTo((K) keys.get(i)) == 0) {
                values.set(i, value);
                break;
            }

            if (i == keys.size() - 1) {
                keys.add(key);
                values.add(value);
                size++;
            }
        }
    }

    public V get(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key.compareTo((K) keys.get(i)) == 0) {
                return (V) values.get(i);
            }
        }
        return null;
    }

    public void delete(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key.compareTo((K) keys.get(i)) == 0) {
                keys.remove(i);
//                while (i < keys.size() - 1) {
//                    keys.set(i, keys.get(i + 1));
//                    values.set(i, values.get(i + 1));
//                    i++;
//                }
                size--;
            }
        }
    }

    public boolean contains(K key) {
        for (Object key1 : keys) {
            if (key.compareTo((K) key1) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public K min() {
        List<K> list = new ArrayList<>();
        keys.forEach(o -> list.add((K) o));

        Collections.sort(list);
        return (K) list.get(0);
    }

    public K max() {
        List<K> list = new ArrayList<>();
        keys.forEach(o -> list.add((K) o));
        Collections.sort(list);
        return (K) list.get(list.size() - 1);
    }


    private K indexKey(int index) {
        return (K) keys.get(index);
    }

    private V indexValue(int index) {
        return (V) values.get(index);
    }

    public K floor(K key) {
        Arrays.sort(new List[]{keys});
        if (indexKey(0).compareTo(key) > 0) {
            return null;
        }

        K floor = indexKey(0);
        for (int i = 0; i < keys.size(); i++) {
            if (indexKey(i).compareTo(key) <= 0 && indexKey(i).compareTo(floor) > 0) {
                floor = indexKey(i);
            }
        }
        return floor;
    }

    public K ceiling(K key) {
        Arrays.sort(new List[]{keys});
        if (indexKey(keys.size() - 1).compareTo(key) < 0) {
            return null;
        }

        K ceiling = indexKey(keys.size() - 1);
        for (int i = 0; i < keys.size(); i++) {
            if (indexKey(i).compareTo(key) >= 0 && indexKey(i).compareTo(ceiling) < 0) {
                ceiling = indexKey(i);
            }
        }
        return ceiling;
    }

    public int rank(K key) {
        int count = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (indexKey(i).compareTo(key) < 0) {
                count++;
            }
        }
        return count;
    }

    public K select(int k) {
        if (k < 0) {
            return null;
        }
        if (k > keys.size() - 1) {
            return null;
        }

        return indexKey(k);
    }

    public void deleteMin() {
        this.delete(min());
    }

    public void deleteMax() {
        this.delete(max());
    }

    public int size(K lo, K hi) {
        Arrays.sort(new List[]{keys});
        if (lo.compareTo(indexKey(keys.size() - 1)) > 0) {
            return 0;
        }
        if (hi.compareTo(indexKey(0)) < 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (indexKey(i).compareTo(lo) > 0 && indexKey(i).compareTo(hi) < 0) {
                count++;
            }
        }
        return count;
    }

    public Iterable<K> keys(K lo, K hi) {
        Arrays.sort(new List[]{keys});
        if (lo.compareTo(indexKey(keys.size() - 1)) > 0) {
            return null;
        }
        if (hi.compareTo(indexKey(0)) < 0) {
            return null;
        }
        Iterable<K> iterable = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            if (indexKey(i).compareTo(lo) > 0 && indexKey(i).compareTo(hi) < 0) {
                ((ArrayList<K>) iterable).add(indexKey(i));
            }
        }
        return iterable;
    }


    public static void main(String[] args) {

        ST<String, String> st = new ST<>(10);
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
        Assert.check(8 == st.size("jack0001", "jack0010"));
        st.delete("jack0012");
        Assert.check(!st.contains("jack0012"));

        Assert.check(st.max().equals("jack2000"));
        Assert.check(st.min().equals("jack0001"));
        st.deleteMax();
        Assert.check(st.max().equals("jack1999"));

        st.deleteMin();
        Assert.check(st.min().equals("jack0002"));
        Assert.check(!st.select(1).equals("jack0003"));
        Assert.check(st.rank("jack0003") == 1);


    }
}

