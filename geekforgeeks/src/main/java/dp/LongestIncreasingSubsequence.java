package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/longest-increasing-subsequence/
 * Created by deep20jain on 31-03-2018.
 */
public class LongestIncreasingSubsequence {
    public int lis_iterative(int[] arr) {
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i]<(dp[j]+1))
                    dp[i] = dp[j] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(dp[i]>max)
                max = dp[i];
        }

        return max;
    }

    public List<Integer> lis_iterative2(int[] arr) {
        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(arr[i]);
            dp.add(l);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp.get(i).size()<(dp.get(j).size()+1)) {
                    List<Integer> l2 = new ArrayList<>(dp.get(j));
                    l2.add(arr[i]);
                    dp.set(i, l2);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.size(); i++) {
            if(dp.get(i).size()>dp.get(max).size())
                max = i;
        }

        System.out.println(max);
        return dp.get(max);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lis_iterative(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
        System.out.println(lis.lis_iterative(new int[]{10, 22, 9, 33, 1, 2, 3, 4, 5}));

        System.out.println(lis.lis_iterative2(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
        System.out.println(lis.lis_iterative2(new int[]{10, 22, 9, 33, 1, 2, 3, 4, 5}));
    }
}
