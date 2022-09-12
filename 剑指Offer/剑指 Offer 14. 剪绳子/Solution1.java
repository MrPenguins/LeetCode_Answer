// 动态规划
// 时间复杂度O(n^2)
// 空间复杂度O(n)

class Solution {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (dp[j] * dp[i - j] > dp[i]) {
                    dp[i] = dp[j] * dp[i - j];
                }
            }
        }
        return dp[n];
    }
}