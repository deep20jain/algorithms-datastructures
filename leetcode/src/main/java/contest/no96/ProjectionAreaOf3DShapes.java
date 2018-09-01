package contest.no96;

/**
 * Created by deep20jain on 05-08-2018.
 */
public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int xyplane = 0, yzplane = 0, xzplane = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]!=0)
                    xyplane++;
            }
        }

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                if(grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            yzplane+=max;
        }

        for (int i = 0; i < m; i++) {
            int max=0;
            for (int j = 0; j < n; j++) {
                if(grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            xzplane+=max;
        }

        return xyplane+xzplane+yzplane;
    }
}
