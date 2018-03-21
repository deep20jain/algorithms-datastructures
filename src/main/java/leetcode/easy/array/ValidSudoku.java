package leetcode.easy.array;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by deep20jain on 17-03-2018.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if(!validate(board, i, i, 0, 8))
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            if(!validate(board, 0, 8, i, i))
                return false;
        }
        for (int i = 0; i < 9; i=i+3) {
            for (int j = 0; j < 9; j=j+3) {
                if(!validate(board, i, i+2, j, j+2))
                    return false;
            }
        }
        return true;
    }

    private boolean validate(char[][] board, int i1, int i2, int j1, int j2) {
        Set<Integer> set = new HashSet<>();
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if(board[i][j]=='.')
                    continue;
                int num = Integer.parseInt(Character.toString(board[i][j]));
                if(num<1 && num>9)
                    return false;
                if(set.contains(num))
                    return false;
                set.add(num);
            }
        }
        return true;
    }
}
