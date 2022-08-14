// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }
}