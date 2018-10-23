import sun.text.CollatorUtilities;
import sun.text.resources.cldr.ti.FormatData_ti;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/10/22 上午10:30
 */
public class MergeSort {

    public int[] mergeSort(int[] a) {

        int mid = a.length / 2;

        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);

        if (a.length > 2) {
            left = mergeSort(left);
            right = mergeSort(right);
        }
        return merge(left, right);
    }

    private int[] merge(int[] b, int[] c) {
        int[] rs = new int[b.length + c.length];
        int i = 0;
        int j = 0;
        int length = 0;
        while (i < b.length || j < c.length) {
            if (i == b.length) {
                while (j < c.length) {
                    rs[length++] = c[j++];
                }
                break;
            }
            if (j == c.length) {
                while (i < b.length) {
                    rs[length++] = b[i++];
                }
                break;
            }
            if (b[i] <= c[j]) {
                rs[length++] = b[i++];
            } else {
                rs[length++] = c[j++];
            }
        }
        return rs;
    }
}
