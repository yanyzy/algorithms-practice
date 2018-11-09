package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhyee
 * @date 2018/11/8 下午4:25
 */
public class Dedup {

    //不及格，数组去重，排序

    public String[] dedup(String[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        List list = Arrays.asList(a);
        Set set = new HashSet(list);
        return (String[]) set.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Dedup().dedup(new String[]{"w", "f", "e", "x", "w"})));
        System.out.println(Arrays.toString(new Dedup().dedup(new String[]{"a", "d", "e", "x", "w"})));
        System.out.println(Arrays.toString(new Dedup().dedup(new String[]{"z", "a", "e", "x", "w"})));
    }
}
