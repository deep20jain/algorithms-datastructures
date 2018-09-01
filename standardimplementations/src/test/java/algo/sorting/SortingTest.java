package algo.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by deep20jain on 28-04-2018.
 */
public class SortingTest {
    private static final int[][] IN = {
            {},
            {1},
            {2, 5, 3, 0, 4},
            {1, 2, 3, 4},
            {4, 3, 2, 1}
    };

    private static final int[][] OUT = {
            {},
            {1},
            {0, 2, 3, 4, 5},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
    };

    @Test
    public void testHeapSort() {
        verify(new HeapSort());
    }

    @Test
    public void testMergeSort() {
        verify(new MergeSort());
    }

    @Test
    public void testQuickSort() {
        verify(new QuickSort());
    }

    @Test
    public void testQuickSortWihRandomPivot() {
        verify(new QuickSortWithRandomPivot());
    }

    @Test
    public void testBubbleSort() {
        verify(new BubbleSort());
    }

    @Test
    public void testSelectionSort() {
        verify(new SelectionSort());
    }

    @Test
    public void testInsertionSort() {
        verify(new InsertionSort());
    }

    public void verify(Sort sortingAlgo) {
        for (int i = 0; i < IN.length; i++) {
            int[] input = IN[i].clone();
            sortingAlgo.sort(input);

            for (int j = 0; j < input.length; j++) {
                Assert.assertEquals(OUT[i][j], input[j]);
            }
        }
    }
}
