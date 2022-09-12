// (n-1)，二进制串n最右边的1变0，这个1右边的0变1
// n&(n-1)，会将二进制串n最右边的一个1变0
// 时间复杂度O(k)，k为二进制串中1的个数
// 空间复杂度O(1)

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}