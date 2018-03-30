package leetcode.medium.array;

/**
 * Created by deep20jain on 30-03-2018.
 */
//TODO look at O(n) solution using manacher algorithm
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s1 = "ccc";
        String s2 = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        String s3 = "bcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcnhbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbchjbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcmkbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcklbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcnbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcdfbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbctybcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcuibcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcopbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbcdfbcbdbebsbqbtbybgbdbcdbhbsbbxbhbsbzbhbibybwbqbxbbkbjblbcnbfbtbxbhbsbxbgbtbsdfjhskdfhbashfjsbsfhsdbaskjcbfjssdblsdhsjdbdslhsbddaabdaebdtbbcdbexbezbdbchbrsbcpbmxbpbhbswbxbsbdfbbcmbxbsbgbxbtbcgbyhbbtbclbybdbfbcpbcvbbkbmbjbhbnubnhhbnfdcgbghcbdhcbdhcbdjdxbvjvfbc";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome_custom(s1));
        System.out.println(longestPalindromicSubstring.longestPalindrome_custom(s2));
        System.out.println(longestPalindromicSubstring.longestPalindrome_custom(s3));

        System.out.println(longestPalindromicSubstring.longestPalindrome_dp(s1));
        System.out.println(longestPalindromicSubstring.longestPalindrome_dp(s2));
        System.out.println(longestPalindromicSubstring.longestPalindrome_dp(s3));
    }


    //(O(n^2) solution
    public String longestPalindrome_dp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1, start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                dp[i][i + 1] = true;
                max = 2;
                start = i;
                end = i+1;
            }                
            else
                dp[i][i+1] = false;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if(s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1]) {
                    dp[j][j+i] = true;
                    max = Math.max(max, i+1);
                    start = j;
                    end = j+i;
                } else {
                    dp[j][j+i] = false;
                }
            }            
        }

        return s.substring(start, end+1);
    }

    public String longestPalindrome_custom(String s) {
        int n = s.length();
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int j = n-1;
            while (j>i) {
                while (j>i && s.charAt(j) != c) {
                    j--;
                }
                if (j>i && isPalindrome(s, i, j)) {
                    if ((j - i + 1) > max) {
                        max = Math.max(max, j - i + 1);
                        maxStart = i;
                        maxEnd = j;
                    }
                    break;
                }
                j--;
            }
        }

        return s.substring(maxStart, maxEnd+1);
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i>j)
            return false;
        if (i==j)
            return true;

        while(i<j && s.charAt(i) == s.charAt(j)){
            i++;j--;
        }

        return i<j ? false : true;
    }

    /**
     * Test cases where my original code failed -
     *
     * "ccc"
     * "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
     *
     */

}
