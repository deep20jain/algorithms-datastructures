package easy.array;

/**
 * Created by deep20jain on 03-10-2018.
 */
public class BestTimetoBuyandSellStockII {
    //beats 99 pc solutions
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[buy]) {
                profit += prices[i] - prices[buy];
            }
            buy = i;
        }
        return profit;
    }
}
