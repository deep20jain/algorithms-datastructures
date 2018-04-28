package standard.impl;

/**
 * Created by deep20jain on 28-04-2018.
 */
public class MaxHeap {
    int[] pq;
    int elements;

    public void makeHeap(int[] A) {
        pq = new int[A.length+1];
        elements = 0;

        for (int i = 0; i < A.length; i++) {
            add(A[i]);
        }
    }

    public int extractMax() {
        if(elements < 1) {
            throw new IllegalStateException();
        }

        int x = pq[1];
        pq[1] = pq[elements];
        elements--;
        bubbleDown(1);
        return x;
    }

    private void bubbleDown(int root) {
        int p = root;
        int l = 2*p;
        int r = 2*p+1;
        int max = p;

        if((l < elements+1) && pq[max] < pq[l]) {
            max = l;
        }
        if((r < elements+1) && pq[max] < pq[r]) {
            max = r;
        }

        if(max==p)
            return;

        swap(p, max);
        bubbleDown(max);
    }

    private void add(int x) {
        pq[++elements] = x;
        bubbleUp();
    }

    private void bubbleUp() {
        int p = elements/2;
        int x = elements;
        while (p!=0 && pq[p]<pq[x]) {
            swap(p, x);
            x = p;
            p = p/2;
        }
    }

    private void swap(int p, int x) {
        int t = pq[p];
        pq[p] = pq[x];
        pq[x] = t;
    }
}