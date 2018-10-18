import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhyee
 * @date 2018/10/18 下午6:12
 */
public class BubbleSortTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void bubbleSort() {

        Assert.assertArrayEquals(bubbleSort.bubbleSort(IntArrays.newIntArrays(1, 2, 3, 4, 5)),
                IntArrays.newIntArrays(1, 2, 3, 4, 5));
        Assert.assertArrayEquals(bubbleSort.bubbleSort(IntArrays.newIntArrays(1, 2, -1, 4, 5)),
                IntArrays.newIntArrays(-1, 1, 2, 4, 5));
        Assert.assertArrayEquals(bubbleSort.bubbleSort(IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0)),
                IntArrays.newIntArrays(0, 0, 0, 0, 0, 0, 0, 0));
        Assert.assertArrayEquals(bubbleSort.bubbleSort(IntArrays.newIntArrays(1, -2, 88, 4, 99)),
                IntArrays.newIntArrays(-2, 1, 4, 88, 99));
    }
}