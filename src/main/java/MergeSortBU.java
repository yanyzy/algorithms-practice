import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/10/23 上午11:45
 */
public class MergeSortBU {

    public int[] mergeSort(int[] a, int size) {
        int cycles = a.length % size == 0 ? a.length / size : a.length / size + 1;
        if (cycles == 1) {
            merge(a, 0, size);
            return a;
        }
        for (int i = 0; i <= cycles; i = i + size) {
            merge(a, i, size);
        }
        size = size + size;
        return mergeSort(a, size);
    }

    private int[] merge(int[] a, int lo, int size) {
        int[] aux = new int[size];
        int hi = lo + size - 1;

        if (a.length < size) {
            aux = new int[a.length];
            hi = a.length - 1;
        }
        int leftLow = lo;
        int mid = lo + size / 2;
        int rightLow = lo + size / 2;
        int i = 0;

        while (true) {
            if (leftLow < mid && rightLow <= hi) {
                if (a[leftLow] > a[rightLow]) {
                    aux[i] = a[rightLow];
                    rightLow++;
                } else {
                    aux[i] = a[leftLow];
                    leftLow++;
                }
                i++;
            } else if (leftLow < mid) {
                aux[i] = a[leftLow];
                i++;
                leftLow++;
            } else if (rightLow <= hi) {
                aux[i] = a[rightLow];
                i++;
                rightLow++;
            } else {
                break;
            }
        }
        if (a.length < size) {
            System.arraycopy(aux, 0, a, lo, a.length);
            return a;
        }
        System.arraycopy(aux, 0, a, lo, size);
        return a;
    }
}
