package algo.sorting;

/**
 * Created by deep20jain on 01-09-2018.
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] input) {
        for (int i = input.length; i > 0; i--) {
            for (int j = 1; j < i ; j++) {
                if(input[j-1] > input[j]) {
                    swap(input, j, j-1);
                }
            }
        }
    }

    private void swap(int[] input, int i, int j) {
        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }
}
