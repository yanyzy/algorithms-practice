/**
 * @author zhyee
 * @date 2018/10/18 下午6:07
 */
public class SelectionSort {

    public int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int x = a[i];
                a[i] = a[min];
                a[min] = x;
            }
        }
        return a;
    }
}
