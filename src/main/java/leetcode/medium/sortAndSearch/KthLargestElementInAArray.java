package leetcode.medium.sortAndSearch;

/**
 * Created by deep20jain on 27-04-2018.
 */
public class KthLargestElementInAArray {
    public static void main(String[] args) {
        System.out.println(new KthLargestElementInAArray().findKthLargest(new int[]{3, 1, 2, 4, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);

        return nums[nums.length-k];
    }

    private class HeapSort {
        public void sort(int[] A) {
            int n = A.length;
            for (int i = n/2-1; i >= 0; i--) {
                heapify(A, n, i);
            }

            for (int i = n-1; i >= 0 ; i--) {
                int max = A[0];
                A[0] = A[i];
                A[i] = max;
                heapify(A, i, 0);
            }
        }

        private void heapify(int[] A, int n, int i) {

            int p = i;
            int l = 2*p+1;
            int r = 2*p+2;
            int max = p;

            if(l<n && A[max] < A[l]) {
                max = l;
            }

            if(r<n && A[max] < A[r]) {
                max = r;
            }

            if(max==p)
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
}
