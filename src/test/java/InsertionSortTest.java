import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhyee
 * @date 2018/10/18 下午6:08
 */
public class InsertionSortTest {

    private final InsertionSort insertionSort = new InsertionSort();

    @Test
    public void insertionSort() {
        Assert.assertArrayEquals(insertionSort.insertionSort(IntArrays.newIntArrays(1, 2, 3, 4, 5)),
                IntArrays.newIntArrays(1, 2, 3, 4, 5));
        Assert.assertArrayEquals(insertionSort.insertionSort(IntArrays.newIntArrays(1, 2, -1, 4, 5)),
                IntArrays.newIntArrays(-1, 1, 2, 4, 5));
        Assert.assertArrayEquals(insertionSort.insertionSort(IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0)),
                IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0));
        Assert.assertArrayEquals(insertionSort.insertionSort(IntArrays.newIntArrays(1, -2, 88, 4, 99)),
                IntArrays.newIntArrays(-2, 1, 4, 88, 99));
    }
}