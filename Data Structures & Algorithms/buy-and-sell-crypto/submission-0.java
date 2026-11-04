class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyIndex = 0;
        for (int sellIndex = 1; sellIndex < prices.length; sellIndex++) {
            if (prices[buyIndex] < prices[sellIndex]) {
                int profit = prices[sellIndex] - prices[buyIndex];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyIndex = sellIndex;
            }
        }
        return maxProfit;
    }
}
