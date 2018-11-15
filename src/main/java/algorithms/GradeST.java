package algorithms;

/**
 * @author zhyee
 * @date 2018/11/15 上午10:25
 */
public class GradeST<K, V> {

    private Node first;

    public void put(K key, V val) {
        if (key == null || val == null) {
            return;
        }
        if (first == null) {
            first = new Node(key, val);
            return;
        }
        Node temp = first;
        while (temp.next != null) {
            if (key.equals(temp.key)) {
                temp.val = val;
                return;
            }
            temp = temp.next;
        }
        temp.next = new Node(key, val);
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

    class Node {
        K key;
        V val;
        Node next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}

class Test {
    public static void main(String[] args) {
        GradeST<String, Double> gradeST = new GradeST<>();
        gradeST.put("A+", 4.33);
        gradeST.put("A", 4.00);
        gradeST.put("A-", 3.67);
        gradeST.put("B+", 3.33);
        gradeST.put("B", 3.00);
        gradeST.put("B-", 2.67);
        gradeST.put("C+", 2.33);
        gradeST.put("C", 2.00);
        gradeST.put("C-", 1.67);
        gradeST.put("D", 1.00);
        gradeST.put("F", 0.00);

        String[] grades = new String[]{"A", "B", "C", "D"};
        System.out.println(new Test().average(grades, gradeST));
    }

    private Double average(String[] grades, GradeST<String, Double> gradeST) {
        double average = 0.00;
        double count = 0.00;
        for (int i = 0; i < grades.length; i++) {
            count = count + gradeST.get(grades[i]);
        }
        average = count / grades.length;
        return average;
    }
}

