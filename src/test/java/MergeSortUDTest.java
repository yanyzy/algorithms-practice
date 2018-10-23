import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zhyee
 * @date 2018/10/23 上午10:41
 */
public class MergeSortUDTest {

    private final MergeSortUD mergeSortUD = new MergeSortUD();

    @Test
    public void mergeSort() {
        Assert.assertArrayEquals(mergeSortUD.mergeSort(IntArrays.newIntArrays(1, 2, 3, 4, 5),0,4),
                IntArrays.newIntArrays(1, 2, 3, 4, 5));
        Assert.assertArrayEquals(mergeSortUD.mergeSort(IntArrays.newIntArrays(1, 2, -1, 4, 5),0,4),
                IntArrays.newIntArrays(-1, 1, 2, 4, 5));
        Assert.assertArrayEquals(mergeSortUD.mergeSort(IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0),0,6),
                IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0));
        Assert.assertArrayEquals(mergeSortUD.mergeSort(IntArrays.newIntArrays(1, -2, 88, 4, 99), 0, 4),
                IntArrays.newIntArrays(-2, 1, 4, 88, 99));
        Assert.assertArrayEquals(mergeSortUD.mergeSort(IntArrays.newIntArrays(5, 4, 3, 2, 1), 0, 4),
                IntArrays.newIntArrays(1, 2, 3, 4, 5));
    }
}