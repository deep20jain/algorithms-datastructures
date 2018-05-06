package medium.treeAndGraphs;

/**
 * Created by deep20jain on 08-04-2018.
 */
public class NumberOfIslands {
    public int numIslands_dfs(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    drownIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void drownIsland(char[][] grid, int i, int j) {
        if(grid[i][j]=='0') return;

        grid[i][j]='0';
        if(j<(grid[0].length-1)) drownIsland(grid, i, j+1);
        if(i<(grid.length-1)) drownIsland(grid, i+1, j);
        if(j!=0) drownIsland(grid, i, j-1);
        if(i!=0) drownIsland(grid, i-1, j);
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i+DIRECTIONS[k][0];
                    int y = j+DIRECTIONS[k][1];

                    if(x<m && x>-1 && y<n && y>-1) {
                        uf.union(i*n+j, x*n+y);
                    }
                }
            }
        }
        return uf.getSets();
    }

    //Union Find
    private class UnionFind {
        private int[] p, rank;
        private int count;

        UnionFind(char[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;

            p = new int[rows*cols];
            rank = new int[rows*cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(mat[i][j]=='1') {
                        int ind = i*cols + j;
                        p[ind] = ind;
                        rank[ind] = 1;
                        count++;
                    }
                }
            }
        }

        public int find(int x) {
            if(p[x] == x) {
                return p[x];
            }

            p[x] = find(p[x]);
            return p[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(rank[px] < rank[py]) {
                p[px] = py;
                rank[py]++;
            } else {
                p[py] = px;
                rank[px]++;
            }

            count--;
        }

        public int getSets() {
            return count;
        }
    }
}
