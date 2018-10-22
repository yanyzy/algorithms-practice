import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhyee
 * @date 2018/10/22 下午2:44
 */
public class MergeSortTest {

    private final MergeSort mergeSort = new MergeSort();

    @Test
    public void mergeSort() {
        Assert.assertArrayEquals(mergeSort.mergeSort(IntArrays.newIntArrays(1, 2, 3, 4, 5)),
                IntArrays.newIntArrays(1, 2, 3, 4, 5));
        Assert.assertArrayEquals(mergeSort.mergeSort(IntArrays.newIntArrays(1, 2, -1, 4, 5)),
                IntArrays.newIntArrays(-1, 1, 2, 4, 5));
        Assert.assertArrayEquals(mergeSort.mergeSort(IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0)),
                IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0));
        Assert.assertArrayEquals(mergeSort.mergeSort(IntArrays.newIntArrays(1, -2, 88, 4, 99)),
                IntArrays.newIntArrays(-2, 1, 4, 88, 99));

    }
}