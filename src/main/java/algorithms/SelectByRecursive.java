package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhyee
 * @date 2018/11/8 下午5:13
 */
public class SelectByRecursive {

    public static void main(String[] args) {
        System.out.println(new SelectByRecursive().selectByRecursive(new int[]{2,4,6,1}).toString());
    }

    public List<Integer> selectByRecursive(int[] a) {
        List<Integer> list = new ArrayList<>();
        return selectByRecursive(a, list);
    }

    private List<Integer> selectByRecursive(int[] a, List<Integer> rs) {
        if (a.length == 0) {
            return null;
        }
        if (a.length == 1) {
            rs.add(a[0]);
            return rs;
        }
        int index = getMin(a);
        rs.add(a[index]);
        return selectByRecursive(remove(a, index), rs);
    }

    private int[] remove(int[] a, int index) {
        int[] ints = new int[a.length - 1];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != index) {
                ints[j] = a[i];
                j++;
            }
        }
        return ints;
    }

    private int getMin(int[] a) {
        int rs = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                rs = i + 1;
            }
        }
        return rs;
    }

}
