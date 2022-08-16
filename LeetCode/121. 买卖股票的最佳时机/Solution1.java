// 本题可以理解为动态规划
// 要获得最大收益，我们需要在股票价格最低时买入，价格最高时卖出
// 对于第i天来说，最低股价为min(前i-1天股价的最小值，当天股价)
// 之后只需要更新最大收益即可
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}