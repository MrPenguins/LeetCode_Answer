import java.util.*;

// 我的初始解法，利用哈希的思想，将数组中的每个元素分到其值对应的下标中，统计其出现次数
// 时间复杂度O(n)
// 空间复杂度O(n)
public class Solution {
    /**
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate(int[] numbers) {
        // write code here
        int[] stat = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] >= numbers.length) {
                return -1;
            }
            stat[numbers[i]]++;
            if (stat[numbers[i]] > 1)
                return numbers[i];
        }
        return -1;
    }
}