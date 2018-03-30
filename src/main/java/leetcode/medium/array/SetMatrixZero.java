package leetcode.medium.array;

import java.util.HashSet;
import java.util.Set;

/**
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?


 [
 [0,0,0,5],
 [4,3,1,4],
 [0,1,1,4],
 [1,2,1,3],
 [0,0,1,1]
 ]
=>
 [
 [0,0,0,0],
 [0,0,0,4],
 [0,0,0,0],
 [0,0,0,3],
 [0,0,0,0]
 ]
 * Created by deep20jain on 26-03-2018.
 */
public class SetMatrixZero {

    // O(m+n) space
    public void setZeroes_1(int[][] matrix) {
        if(matrix==null) return;
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]!=0)
                    continue;

                row.add(i);
                col.add(j);
            }
        }

        for (int i : row) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j :col) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    // O(1) space
    public void setZeroes(int[][] matrix) {
        if(matrix==null) return;

        boolean r0 = false;
        boolean c0 = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]!=0)
                    continue;

                if(i==0) {
                    r0 = true;
                }

                if(j==0) {
                    c0 = true;
                }

                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {                                              // Note start from 1
            for (int j = 1; j < n; j++) {
                if(matrix[i][0]==0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(r0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (c0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
