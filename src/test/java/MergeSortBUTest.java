import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhyee
 * @date 2018/10/23 下午2:45
 */
public class MergeSortBUTest {

    private final MergeSortBU mergeSortBU = new MergeSortBU();

    @Test
    public void mergeSort() {
        Assert.assertArrayEquals(mergeSortBU.mergeSort(IntArrays.newIntArrays(1, 2, 3, 4, 5),2),
                IntArrays.newIntArrays(1, 2, 3, 4, 5));
        Assert.assertArrayEquals(mergeSortBU.mergeSort(IntArrays.newIntArrays(1, 2, -1, 4, 5),2),
                IntArrays.newIntArrays(-1, 1, 2, 4, 5));
        Assert.assertArrayEquals(mergeSortBU.mergeSort(IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0),2),
                IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0));
        Assert.assertArrayEquals(mergeSortBU.mergeSort(IntArrays.newIntArrays(1, -2, 88, 4, 99),2),
                IntArrays.newIntArrays(-2, 1, 4, 88, 99));
    }
}