package algo.sorting;

/**
 * Created by deep20jain on 28-04-2018.
 */
public class HeapSort {
    public void sort(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int max = A[0];
            A[0] = A[i];
            A[i] = max;
            heapify(A, i, 0);
        }
    }

    private void heapify(int[] A, int n, int i) {
        int p = i;
        int l = 2 * p + 1;
        int r = 2 * p + 2;
        int max = p;

        if (l < n && A[max] < A[l]) {
            max = l;
        }

        if (r < n && A[max] < A[r]) {
            max = r;
        }

        if (max == p)
            return;

        swap(A, max, p);
        heapify(A, n, max);
    }

    private void swap(int[] a, int max, int p) {
        int t = a[max];
        a[max] = a[p];
        a[p] = t;
    }
}
