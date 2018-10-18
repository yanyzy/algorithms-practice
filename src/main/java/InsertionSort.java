/**
 * @author zhyee
 * @date 2018/10/18 下午6:06
 */
public class InsertionSort {

    public int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int x = a[i];
                if (x < a[j]) {
                    System.arraycopy(a, j, a, j + 1, i - j); //偏移j位
                    a[j] = x;
                    break;
                }
            }
        }
        return a;
    }
}
