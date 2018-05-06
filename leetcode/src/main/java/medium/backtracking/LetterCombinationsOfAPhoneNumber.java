package medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by deep20jain on 09-04-2018.
 */
public class LetterCombinationsOfAPhoneNumber {
    char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        System.out.println(l.letterCombinations_rec("2"));
    }

    public List<String> letterCombinations_iter(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if(digits == null || digits.length()==0) return list;
        list.add("");

        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));

            while (list.peek().length() == i) {
                String temp = list.remove();

                for(char c:map[digit]) {
                    list.add(temp+c);
                }
            }
        }

        return list;
    }

    public List<String> letterCombinations_rec(String digits) {
        return letterCombinationsHelper(digits, 0);
    }

    private List<String> letterCombinationsHelper(String digits, int index) {
        List<String> res = new ArrayList<>();

        if(index>=digits.length()) {
            return res;
        }

        int digit = Character.getNumericValue(digits.charAt(index));
        StringBuilder b = new StringBuilder();

        List<String> substrs = letterCombinationsHelper(digits, index+1);
        if(substrs.isEmpty()) substrs.add("");

        for(String s:substrs) {
            for(char c:map[digit]) {
                b.append(c);
                b.append(s);
                res.add(b.toString());
                b.setLength(0);
            }
        }

        return res;
    }
}
