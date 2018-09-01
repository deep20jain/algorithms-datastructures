package medium.dp;

/**
 * Created by deep20jain on 21-05-2018.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            mat[i][n-1] = 1;
        }

        for (int i = 0; i < n; i++) {
            mat[m-1][i] = 1;
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                mat[i][j] = mat[i+1][j] + mat[i][j+1];
            }
        }

        return mat[0][0];
    }
}
