// 优化的动态规划
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int climbStairs(int n) {
        int x = 0, y = 0, z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }
}