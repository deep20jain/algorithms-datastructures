package leetcode.medium.backtracking;

import java.util.Arrays;

/**
 * Created by deep20jain on 19-04-2018.
 */
public class WordSearch {

    public boolean exist_better(char[][] board, String word) {
        if(board==null || board.length==0)
            return false;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(search(board, word.toCharArray(), 0, i, j, m, n))
                    return true;
            }
        }

        return false;
    }

    private boolean search(char[][] board, char[] chars, int ind, int i, int j, int m, int n) {
        if(ind == chars.length) return true;
        if(i<0 || j<0 || i==m || j==n) return false;
        if(board[i][j]=='#') return false;
        if(board[i][j]!=chars[ind]) return false;

        char ch = chars[ind];

        board[i][j] = '#';

        boolean exist = search(board, chars, ind+1, i+1, j, m, n) ||
                search(board, chars, ind+1, i-1, j, m, n) ||
                search(board, chars, ind+1, i, j+1, m, n) ||
                search(board, chars, ind+1, i, j-1, m, n);

        board[i][j] = ch;

        return exist;
    }

    //Mine original - too long
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0)
            return false;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(backtrack(board, visited, word.toCharArray(), 0, i, j, m, n))
                    return true;
                reset(visited, m, n);
            }
        }

        return false;
    }

    private void reset(boolean[][] visited, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    private boolean backtrack(char[][] board, boolean[][] visited, char[] chars, int ind, int i, int j, int m, int n) {
        if(ind==chars.length) {
            return true;
        }

        if(visited[i][j])
            return false;

        char ch = chars[ind];

        if(board[i][j] != chars[ind])
            return false;

        visited[i][j] = true;

        if(i<(m-1)) {
            if(backtrack(board, visited, chars, ind+1, i+1, j, m, n))
                return true;
        }

        if(j<(n-1)) {
            if(backtrack(board, visited, chars, ind+1, i, j+1, m, n))
                return true;
        }

        if(i>0) {
            if(backtrack(board, visited, chars, ind+1, i-1, j, m, n))
                return true;
        }

        if(j>0) {
            if(backtrack(board, visited, chars, ind+1, i, j-1, m, n))
                return true;
        }

        if(ind == (chars.length-1))
            return true;

        visited[i][j] = false;

        return false;
    }
}
