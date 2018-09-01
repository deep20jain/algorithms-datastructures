package algo.sorting;

/**
 * Created by deep20jain on 01-09-2018.
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int temp = input[i];
            int j = i-1;

            while (j>=0 && input[j]>temp) {
                input[j+1] = input[j];
                j--;
            }

            input[j+1] = temp;
        }
    }
}
