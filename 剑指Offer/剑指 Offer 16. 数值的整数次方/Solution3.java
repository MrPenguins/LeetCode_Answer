// 迭代
// 时间复杂度O(log n)
// 空间复杂度O(1)

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans = 1.0;
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= x;
            }
            x *= x;
            b >>= 1;
        }
        return ans;
    }
}