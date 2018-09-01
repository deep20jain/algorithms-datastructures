package algo.sorting;

/**
 * Created by deep20jain on 01-09-2018.
 */
public class SelectionSort implements Sort {
    @Override
    public void sort(int[] input) {
        for (int i = 0; i < input.length-1; i++) {
            int min = i;
            for (int j = i+1; j < input.length; j++) {
                if(input[j]<input[min]){
                    min = j;
                }
            }
            swap(input, i, min);
        }
    }

    private void swap(int[] input, int i, int j) {
        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }
}
