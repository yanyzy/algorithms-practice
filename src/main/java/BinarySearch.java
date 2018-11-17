import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/11/17 下午6:30
 */
public class BinarySearch {

    public int rank(int[] a, int k) {

        if (a.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (k == a[mid]) {
                return mid;
            }
            if (k < a[mid]) {
                hi = mid - 1;
            }
            if (k > a[mid]) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().rank(new int[]{1, 3, 5, 8, 9}, 2));
    }
}
