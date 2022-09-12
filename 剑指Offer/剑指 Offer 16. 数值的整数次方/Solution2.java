// 迭代
// 时间复杂度O(log n)
// 空间复杂度O(1)

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans = 1.0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            if (i % 2 != 0) {
                ans *= x;
            }
        }
        return n < 0 ? 1.0 / ans : ans;
    }
}