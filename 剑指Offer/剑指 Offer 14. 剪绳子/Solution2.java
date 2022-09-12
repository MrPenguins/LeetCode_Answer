// 贪心，由复杂的数学推导可知，在n>=4时，将绳子尽可能多得切成长度为3的小段，乘积最大
// 但当 n mod 3 = 1 时，最后留下的长度为4的一段应切成两段2（或者不切），因为 2*2=4>1*3
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long ans = 1;
        while (n > 4) {
            ans = ans * 3 % 1000000007;
            n -= 3;
        }
        return (int) (ans * n % 1000000007);
    }
}