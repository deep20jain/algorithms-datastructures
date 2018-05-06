package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deep20jain on 10-04-2018.
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }

    char[] par = {'(', ')'};

    // #beauty
    // See for complexity - https://leetcode.com/problems/generate-parentheses/solution/
    // nth catalan number
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String s, int open, int closed, int n) {
        if(s.length() == 2*n) {
            res.add(s);
            return;
        }

        if(open < n) {
            backtrack(res, s+"(", open+1, closed, n);
        }
        if(closed < open) {
            backtrack(res, s+")", open, closed+1, n);
        }
    }


    //Mine - long
    public List<String> generateParenthesis_mine(int n) {
        int size = 2*n;
        List<String> res = new ArrayList<>();
        if(n==0) {
            return res;
        }

        for(String s:getValidPrefixes(size-1)) {
            String candidate = s+')';
            if(isValid(candidate, false)) {
                res.add(candidate);
            }
        }

        return res;
    }

    private List<String> getValidPrefixes(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) {
            return res;
        }

        if(n==1) {
            res.add("(");
            return res;
        }

        for(String s:getValidPrefixes(n-1)){
            for(char c:par) {
                String candidate = s+c;
                if (isValid(candidate, true)) {
                    res.add(candidate);
                }
            }
        }

        return res;
    }

    private boolean isValid(String s, boolean prefix) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(count<0)
                return false;
            if(isOpening(s.charAt(i)))
                count++;
            else
                count--;
        }

        return prefix ? count>=0 : count==0;
    }

    private boolean isOpening(char c) {
        return c=='(';
    }
}
