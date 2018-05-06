package leetcode.medium.sortAndSearch;

/**
 * Created by deep20jain on 02-05-2018.
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        System.out.println(new SearchA2DMatrixII().max(new int[]{1, 2, 3, 5, 6}, 0, 0, 4));
    }

    private int max(int[] a, int x, int l, int r) {
        while (l<r) {
            int mid = l + ((r-l)/2);

            if (x == a[mid])
                return mid;
            else if (a[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix[0].length-1;
        while (l<r) {
            int mid = l + ((r-l)/2);

            if (target == matrix[0][mid])
                return true;
            else if (matrix[0][mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        int cMax = l;

        l = 0; r = matrix.length-1;
        while (l < r) {
            int mid = l + ((r-l)/2);

            if (target == matrix[mid][0])
                return true;
            else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        int rMax = l;

        for (int i = 0; i <= rMax; i++) {
            if(binary(matrix[i], target, 0, cMax))
                return true;
        }

        return false;
    }

    private boolean binary(int[] a, int x, int l, int r) {
        while (l<r) {
            int mid = l  + ( (r - l)/2);

            if(a[mid] == x)
                return true;
            else if(a[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
