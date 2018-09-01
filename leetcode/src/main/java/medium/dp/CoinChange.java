package medium.dp;

import java.util.Arrays;

/**
 * Created by deep20jain on 25-05-2018.
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];

        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        Arrays.sort(coins);

        for (int i = 1; i < amount + 1; i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = -1;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount+1; j++) {
                if(j<coins[i]) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }

                if(dp[i-1][j]!=-1 && dp[i][j-coins[i]]!=-1)
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i]]);
                else if (dp[i][j-coins[i]]!=-1)
                    dp[i][j] = 1 + dp[i][j-coins[i]];
                else
                    dp[i][j] = dp[i-1][j];

            }
        }

        return dp[coins.length-1][amount];
    }
}
