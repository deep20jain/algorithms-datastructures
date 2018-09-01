package algo.sorting;

/**
 * Created by deep20jain on 28-04-2018.
 */
public class QuickSort implements Sort {
    public void sort(int[] a) {
        quicksort(a, 0, a.length-1);
    }

    private void quicksort(int[] a, int low, int high) {
        if(low < high) {
            int p = partition(a, low, high);
            quicksort(a, low, p-1);
            quicksort(a, p+1, high);
        }
    }

    private int partition(int[] a, int low, int high) {
        int p = high;
        int x = low-1;

        for (int i = low; i< high; i++) {                          //#note - < not <=
            if(a[i] <= a[p]) {
                x++;
                swap(a, i, x);
            }
        }

        x++;
        swap(a, x, p);
        return x;
    }

    private void swap(int[] a, int i, int x) {
        int t = a[i];
        a[i] = a[x];
        a[x] = t;
    }
}
