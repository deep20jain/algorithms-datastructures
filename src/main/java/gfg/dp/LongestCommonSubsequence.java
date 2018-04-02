package gfg.dp;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence/
 * Created by deep20jain on 31-03-2018.
 */
public class LongestCommonSubsequence {
    public String  lcs(String a, String b) {
        return lcs_re(a.toCharArray(), b.toCharArray(), a.length(), b.length());
    }

    private String lcs_re(char[] a, char[] b, int m, int n) {
        if(m==0 || n==0) {
            return "";
        }

        if(a[m-1]==b[n-1]) {
            return a[m-1]+lcs_re(a, b, m-1, n-1);
        } else {
            String l = lcs_re(a, b, m, n-1);
            String r = lcs_re(a, b, m-1, n);
            return l.length() > r.length() ? l : r;
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.lcs("ABCDGH", "AEDFHR"));
    }

}
