package algorithms.strings;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/12/26 下午6:12
 */
public class KeyIndex {

    Student[] sort(Student[] students, int r) {

        int length = students.length;
        int[] count = new int[r + 1];
        Student[] aux = new Student[length];

        for (int i = 0; i < length; i++) {
            count[students[i].getKey() + 1]++;
        }
        for (int j = 0; j < r; j++) {
            count[j + 1] = count[j + 1] + count[j];
        }
        for (int i = 0; i < length; i++) {
            aux[count[students[i].getKey()]++] = students[i];
        }
        for (int i = 0; i < length; i++) {
            students[i] = aux[i];
        }
        return students;
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{new Student("zhang", 2),
                new Student("wang", 1),
                new Student("li", 2),
                new Student("wu", 2),
                new Student("yan", 3)};
        System.out.println(Arrays.toString(new KeyIndex().sort(students, 4)));
    }

}

class Student {
    String name;
    int key;

    public Student(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", key=" + key +
                '}';
    }
}
