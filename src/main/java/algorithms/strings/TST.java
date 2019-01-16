package algorithms.strings;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2019/1/16 上午10:43
 */
public class TST<V> {

    private Node root;

    private class Node {
        char c;
        V val;
        Node left;
        Node mid;
        Node right;
    }

    private V get(String key) {
        Node n = get(root, key, 0);
        return n == null ? null : n.val;
    }

    private Node get(Node n, String key, int d) {
        if (n == null) {
            return null;
        }
        if (d == key.length() - 1) {
            return n;
        }
        char h = key.charAt(d);
        Node next = null;
        if (h < n.c) {
            next = n.left;
        } else if (h == n.c) {
            next = n.mid;
            d = d + 1;
        } else {
            next = n.right;
        }
        return get(next, key, d);
    }

    void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    Node put(Node n, String key, V val, int d) {

        char c = key.charAt(d);
        if (n == null) {
            n = new Node();
            n.c = c;
        }
        if (c < n.c) {
            n.left = put(n.left, key, val, d);
        } else if (c > n.c) {
            n.right = put(n.right, key, val, d);
        } else if (d < key.length() - 1) {
            n.mid = put(n.mid, key, val, d + 1);
        } else {
            n.val = val;
        }
        return n;
    }

    public static void main(String[] args) {
        TST<Integer> tst = new TST<>();
        tst.put("test", 9);
        tst.put("by", 2);
        tst.put("she", 3);
        tst.put("tyan", 5);
        Assert.check(9 == tst.get("test"));
        Assert.check(2 == tst.get("by"));
        Assert.check(3 == tst.get("she"));
        Assert.check(5 == tst.get("tyan"));
    }
}

