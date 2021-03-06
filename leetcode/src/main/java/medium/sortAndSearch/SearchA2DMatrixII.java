package medium.sortAndSearch;

/**
 * #repeat
 * Created by deep20jain on 02-05-2018.
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
    }

    // #beauty #note
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length-1;

        while (row<matrix.length && col>=0) {
            if(matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }

        return false;
    }
}
