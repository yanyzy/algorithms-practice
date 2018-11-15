package algorithms;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2018/11/15 上午11:31
 */
public class OrderedSequentialSearchST<K extends Comparable<K>, V> {

    private Node first;
    private int size;

    public void put(K key, V val) {
        if (key == null || val == null) {
            return;
        }
        if (first == null) {
            first = new Node(key, val);
            return;
        }

        Node temp = first;
        Node pre = null;
        while (temp.next != null) {
            if (key.compareTo(temp.key) <= 0) {
                if (key.equals(temp.key)) {
                    temp.val = val;
                } else {
                    size++;
                    Node newNode = new Node(key, val);

                    if (pre == null) {
                        first = newNode;
                        first.next = temp;
                    } else {
                        pre.next = newNode;
                        newNode.next = temp;
                    }
                }
                return;
            }
            pre = temp;
            temp = temp.next;
        }
        temp.next = new Node(key, val);
        size++;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        Node temp = first;
        while (temp.next != null) {
            if (key.equals(temp.key)) {
                return temp.val;
            }
            temp = temp.next;
        }
        return null;
    }

    public void delete(K key) {
        if (key == null) {
            return;
        }
        Node temp = first;
        Node pre = null;
        while (temp.next != null) {
            if (key.compareTo(temp.key) == 0) {
                if (pre == null) {
                    first = temp.next;
                } else {
                    pre.next = temp.next;
                }
                size--;
            }
            pre = temp;
            temp = temp.next;
        }
    }

    private boolean contains(K key) {
        if (key == null) {
            return false;
        }
        Node temp = first;
        while (temp.next != null) {
            if (key.compareTo(temp.key) == 0) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int size() {
        return size;
    }

    private K min() {
        return first.key;
    }

    public K max() {
        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.key;
    }

    public K floor(K key) {
        if (key == null) {
            return null;
        }
        Node temp = first;
        while (temp.next != null) {
            if (temp.key.compareTo(key) <= 0 && temp.next.key.compareTo(key) > 0) {
                return temp.key;
            }
        }
        return temp.key;
    }

    public K ceiling(K key) {
        if (key == null) {
            return null;
        }
        Node temp = first;
        while (temp.next != null) {
            if (temp.key.compareTo(key) <= 0 && temp.next.key.compareTo(key) > 0) {
                return temp.next.key;
            }
        }
        return null;
    }

    public int rank(K key) {
        if (key == null) {
            return 0;
        }
        int count = 0;
        Node temp = first;
        while (temp.next != null && temp.key.compareTo(key) < 0) {
            count++;
            temp = temp.next;
        }
        if (temp.key.compareTo(key) < 0) {
            count++;
        }
        return count;
    }

    public K select(int index) {
        if (index < 0) {
            return null;
        }
        if (index > size - 1) {
            return null;
        }
        Node temp = first;
        while (temp.next != null && index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.key;
    }

    private class Node {
        K key;
        V val;
        Node next;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {

        OrderedSequentialSearchST<String, String> st = new OrderedSequentialSearchST<>();
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

        Assert.check(st.max().equals("jack1999"));
        Assert.check(st.min().equals("jack0001"));
//        st.deleteMax();
//        Assert.check(st.max().equals("jack1999"));
//
//        st.deleteMin();
//        Assert.check(st.min().equals("jack0002"));
//        Assert.check(!st.select(1).equals("jack0003"));
//        Assert.check(st.rank("jack0003") == 1);


    }
}
