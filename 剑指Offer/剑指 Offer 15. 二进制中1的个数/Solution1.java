// 依次判断二进制串每一位是否为1
// 时间复杂度O(k)，k为二进制串的长度
// 空间复杂度O(1)

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // 与1即能判断二进制串末位是否为1
            count += n & 1;
            // 无符号右移一位（左侧补零）
            n >>>= 1;
        }
        return count;
    }
}