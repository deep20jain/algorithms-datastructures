package standard.impl.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by deep20jain on 28-04-2018.
 */
public class SortingTest {
    private static final int[][] IN = {
            {1},
            {2, 5, 3, 0, 4},
            {1, 2, 3, 4}
    };

    private static final int[][] OUT = {
            {1},
            {0, 2, 3, 4, 5},
            {1, 2, 3, 4}
    };

    @Test
    public void testHeapSort() {
        HeapSort heapSort = new HeapSort();

        for (int i = 0; i < IN.length; i++) {
            int[] input = IN[i];
            heapSort.sort(input);

            for (int j = 0; j < input.length; j++) {
                Assert.assertEquals(OUT[i][j], input[j]);
            }
        }
    }

    @Test
    public void testMergeSort() {
        MergeSort sort = new MergeSort();

        for (int i = 0; i < IN.length; i++) {
            int[] input = IN[i];
            sort.sort(input);

            for (int j = 0; j < input.length; j++) {
                Assert.assertEquals(OUT[i][j], input[j]);
            }
        }
    }

    @Test
    public void testQuickSort() {
        QuickSort sort = new QuickSort();

        for (int i = 0; i < IN.length; i++) {
            int[] input = IN[i];
            sort.sort(input);

            for (int j = 0; j < input.length; j++) {
                Assert.assertEquals(OUT[i][j], input[j]);
            }
        }
    }

    @Test
    public void testQuickSortWihRandomPivot() {
        QuickSortWithRandomPivot sort = new QuickSortWithRandomPivot();

        for (int i = 0; i < IN.length; i++) {
            int[] input = IN[i];
            sort.sort(input);

            for (int j = 0; j < input.length; j++) {
                Assert.assertEquals(OUT[i][j], input[j]);
            }
        }
    }
}
