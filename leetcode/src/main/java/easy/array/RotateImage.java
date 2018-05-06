package easy.array;

/**
 * Created by deep20jain on 18-03-2018.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N-1-j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
                matrix[j][N-1-i] = temp;
            }
        }
    }

    //take transpose and reverse symmetrically - https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
    public void rotate_2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {                       //Note j=i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {                     //Note j < n/2
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

}
