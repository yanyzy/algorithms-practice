import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2018/11/19 下午3:33
 */
public class BST<K extends Comparable<K>, V> {

    Node root;

    int size() {
        return size(root);
    }

    int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.n;
    }

    void put(K key, V val) {
        if (key == null) {
            return;
        }
        root = put(root, key, val);
    }

    Node put(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = node.key.compareTo(key);

        if (cmp < 0) {
            node.right = put(node.right, key, val);
        } else if (cmp > 0) {
            node.left = put(node.left, key, val);
        } else {
            node.val = val;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    V get(K key) {
        if (key == null) {
            return null;
        }
        return get(root, key);
    }

    V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        }
        if (cmp < 0) {
            return get(node.right, key);
        }
        return node.val;
    }

    Node min() {
        if (root == null) {
            return null;
        }
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    Node max() {
        if (root == null) {
            return null;
        }
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    K floor(K key) {
        if (key == null) {
            return null;
        }
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    Node floor(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        }
        Node t = floor(node.right, key);
        if (t == null) {
            return node;
        }
        return t;
    }

    K ceilong(K key) {
        if (key == null) {
            return null;
        }
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.key;

    }

    Node ceiling(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp > 0) {
            return ceiling(node.right, key);
        }
        Node t = ceiling(node.left, key);
        if (t != null) {
            return t;
        }
        return node;
    }

    K select(int k) {
        if (k < 0) {
            return null;
        }
        return select(root, k);
    }

    K select(Node node, int k) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.key;
        }
        if (k == node.left.n) {
            return node.key;
        }
        if (k < node.left.n) {
            return select(node.left, k);
        }
        return select(node.right, k - node.left.n - 1);
    }

    void deleteMin() {
        Node temp = root;
        while (temp.left.left != null) {
            temp = temp.left;
        }
        temp.left = null;
        temp.n--;
    }

    void deleteMax() {
        Node temp = root;
        while (temp.right.right != null) {
            temp = temp.right;
        }
        temp.right = null;
        temp.n--;
    }

    Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    void delete(K key) {
        root = delete(root, key);
    }

    Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        } else if (cmp < 0) {
            node.left = delete(node.left, key);
        } else {
            node.right = delete(node.right, key);
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    boolean contains(K key) {
        if (key == null) {
            return false;
        }
        return contains(root, key);
    }

    boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }
        int cmp = node.key.compareTo(key);
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return contains(node.right, key);
        }
        return contains(node.left, key);
    }

    class Node {
        private K key;
        private V val;
        private Node left;
        private Node right;
        private int n;

        Node(K key, V val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public static void main(String[] args) {
        BST<String, String> st = new BST<>();
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
