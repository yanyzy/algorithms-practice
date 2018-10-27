import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/10/27 下午11:35
 */
public class QuickSort {

    public int[] quickSort(int[] a) {
        return quickSort(a,/**base**/0,/**base**/a.length - 1);
    }

    private int[] quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return a;
        }
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
        return a;
    }

    private int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo + 1;
        int j = hi;
        while (true) {
            if (i > j) {
                // exchange a[j],v
                a[lo] = a[j];
                a[j] = v;
                break;
            } else if (a[i] > v && a[j] < v) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            } else if (a[i] > v) {
                j--;
            } else if (a[j] < v) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return j;
    }
}
