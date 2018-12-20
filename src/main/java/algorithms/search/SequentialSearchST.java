package algorithms.search;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2018/12/20 下午3:00
 */
public class SequentialSearchST<K extends Comparable<K>, V> {
    private Node first;

    void put(K key, V value) {
        if (key == null) {
            return;
        }
        if (first == null) {
            first = new Node(key, value);
            return;
        }
        Node temp = first;
        while (temp.next != null) {
            if (temp.key.compareTo(key) == 0) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        if (temp.key.compareTo(key) == 0) {
            temp.value = value;
            return;
        }
        temp.next = new Node(key, value);
    }

    V get(K key) {
        if (key == null) {
            return null;
        }

        if (first == null) {
            return null;
        }

        Node temp = first;
        while (temp.next != null) {
            if (temp.key.compareTo(key) == 0) {
                return temp.value;
            }
            temp = temp.next;
        }
        if (temp.key.compareTo(key) == 0) {
            return temp.value;
        }
        return null;
    }

    void delete(K key) {
        if (key == null) {
            return;
        }
        if (key.equals(first.key)) {
            first = first.next;
            return;
        }

        Node temp = first;
        Node pre = null;
        while (temp.next != null) {
            if (temp.key.compareTo(key) == 0) {
                pre.next = temp.next;
                return;
            }
            pre = temp;
            temp = temp.next;
        }

        if (temp.key.compareTo(key) == 0) {
            pre.next = null;
        }
    }

    class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SequentialSearchST<String, String> st = new SequentialSearchST<>();
        st.put("1", "hi");
        st.put("2", "hello");
        Assert.check(st.get("2").equals("hello"));
        st.delete("2");
        Assert.checkNull(st.get("2"));
    }
}
