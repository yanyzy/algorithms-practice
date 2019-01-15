package algorithms.strings;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2019/1/15 下午3:03
 */
public class TrieST<V> {

    Node root;
    int R = 256;

    V get(String key) {
        Node n = get(root, key, 0);
        return n == null ? null : (V) n.val;
    }

    Node get(Node n, String key, int d) {
        if (n == null) {
            return null;
        }
        if (d == key.length()) {
            return n;
        }
        char c = key.charAt(d);
        return get(n.nodes[c], key, d + 1);
    }

    void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    Node put(Node n, String key, V val, int d) {

        if (n == null) {
            n = new Node();
        }

        if (d == key.length()) {
            n.val = val;
            return n;
        }
        char c = key.charAt(d);
        n.nodes[c] = put(n.nodes[c], key, val, d + 1);
        return n;
    }

    void delete(String key) {
        root = delete(root, key, 0);
    }

    Node delete(Node n, String key, int d) {
        if (n == null) {
            return null;
        }
        if (d == key.length()) {
            n.val = null;
        } else {
            char c = key.charAt(d);
            n.nodes[c] = delete(n.nodes[c], key, d + 1);
        }

        if (n.val != null) {
            return n;
        }
        for (Node node : n.nodes) {
            if (node != null) {
                return n;
            }
        }
        return null;
    }

    boolean contains(String key) {
        return get(key) != null;
    }

    Iterable<String> keys() {
        return keysWithPrefix("");
    }

    Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    void collect(Node n, String pre, Queue<String> queue) {
        if (n == null) {
            return;
        }
        if (n.val != null) {
            queue.enqueue(pre);
        }
        for (char c = 0; c < R; c++) {
            collect(n.nodes[c], pre + c, queue);
        }
    }

    Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    void collect(Node n, String pre, String pat, Queue<String> queue) {
        if (n == null) {
            return;
        }
        if (n.val != null) {
            queue.enqueue(pre);
        }
        int d = pre.length();
        if (d == pat.length()) {
            return;
        }
        char c = pat.charAt(d);
        if (c == '.') {
            for (char i = 0; i < R; i++) {
                collect(n.nodes[i], pre + i, pat, queue);
            }
        } else {
            collect(n.nodes[c], pre + c, pat, queue);
        }

    }

    String longestPrefix(String s) {
        int index = search(root, s, 0, 0);
        return s.substring(0, index);
    }

    int search(Node n, String s, int d, int length) {
        if (n == null) {
            return length;
        }
        if (n.val != null) {
            length = d;
        }
        if (d == s.length()) {
            return length;
        }
        return search(n.nodes[s.charAt(d)], s, d + 1, length);
    }

    public static void main(String[] args) {
        TrieST<Integer> trieST = new TrieST<>();
        trieST.put("by", 2);
        trieST.put("be", 4);
        trieST.put("bb", 8);
        trieST.put("sh", 5);
        trieST.put("she", 6);

        Assert.check(trieST.get("by").equals(2));
        Assert.check(trieST.get("be").equals(4));
        Assert.check(trieST.get("bb").equals(8));
        Assert.check(trieST.get("sh").equals(5));
        Assert.check(trieST.get("she").equals(6));

        trieST.delete("be");

        Assert.checkNull(trieST.get("be"));
        Assert.check(trieST.contains("by"));

    }
}

class Node {
    Object val;
    Node[] nodes;

    public Node() {
        this.nodes = new Node[256];
    }
}


