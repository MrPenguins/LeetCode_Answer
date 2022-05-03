// 动态规划，我的初始解法
// 其实这里的ans[i][0]就等于ans[i-1][1]，因此可以优化
// 时间复杂度O(n)
// 空间复杂度O(n)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        ine[][] ans = new ine[n][2];
        ans[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i][0] = Math.max(ans[i - 1][0], ans[i - 1][1]);
            ans[i][1] = ans[i - 1][0] + nums[i];
        }
        return Math.max(ans[n - 1][0], ans[n - 1][1]);
    }
}