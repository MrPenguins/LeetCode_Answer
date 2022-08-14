// 因为我们只需要用到前两个数字的值，因此可以将空间复杂度优化为O(1)
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }
}