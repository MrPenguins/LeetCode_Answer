// dp，优化版本
// 状态转移方程（见官方题解）：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int second = 0;
        for (int i : nums) {
            int tmp = Math.max(first + i, second);
            first = second;
            second = tmp;
        }
        return second;
    }
}