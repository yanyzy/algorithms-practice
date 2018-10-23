import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/10/22 下午4:37
 */
public class MergeSortUD {

    public int[] mergeSort(int[] a, int lo, int hi) {
        int size = hi - lo + 1;
        int mid = lo + (size % 2 == 0 ? (size / 2) - 1 : (size / 2));

        int leftLow = lo;
        int rightLow = mid + 1;

        if (size > 2) {
            mergeSort(a, leftLow, mid);
            mergeSort(a, rightLow, hi);
        }

        // sorted two parts [lo .. mid]  [mid+1, hi]
        int[] temp = new int[size];
        int i = 0;

        while (true) {
            if (leftLow <= mid && rightLow <= hi) {
                if (a[leftLow] > a[rightLow]) {
                    temp[i] = a[rightLow];
                    rightLow++;
                    i++;
                } else {
                    temp[i] = a[leftLow];
                    leftLow++;
                    i++;
                }
            } else if (leftLow <= mid) {
                temp[i] = a[leftLow];
                i++;
                leftLow++;
            } else if (rightLow <= hi) {
                temp[i] = a[rightLow];
                i++;
                rightLow++;
            } else {
                //end
                break;
            }
        }
        System.arraycopy(temp, 0, a, lo, size);
        return a;
    }
}
