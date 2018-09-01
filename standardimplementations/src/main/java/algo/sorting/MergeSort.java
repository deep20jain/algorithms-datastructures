package algo.sorting;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by deep20jain on 28-04-2018.
 */
public class MergeSort implements Sort {
    public void sort(int[] a) {
        mergesort(a, 0, a.length-1);
    }

    private void mergesort(int[] a, int low, int high) {
        if( low < high ) {
            int middle = low + ((high-low)/2);
            mergesort(a, low, middle);
            mergesort(a, middle+1, high);
            merge(a, low, middle, high);
        }
    }

    private void merge(int[] a, int low, int middle, int high) {
        Queue<Integer> f = new ArrayDeque<>();
        Queue<Integer> l = new ArrayDeque<>();

        init(a, f, low, middle);
        init(a, l, middle+1, high);
        int i = low;

        while (!f.isEmpty() && !l.isEmpty()) {
            if(f.peek() <= l.peek()) {
                a[i++] = f.poll();
            } else {
                a[i++] = l.poll();
            }
        }

        while (!f.isEmpty()) {
            a[i++] = f.poll();
        }

        while (!l.isEmpty()) {
            a[i++] = l.poll();
        }
    }

    private void init(int[] a, Queue<Integer> f, int low, int middle) {
        for (int i = low; i <= middle; i++) {
            f.add(a[i]);
        }
    }
}
