import java.util.*;

// JZ中的解法，将提供的数组本身作为一个存储数字出现信息的工具
// 交换数组使得数组中第i个数等于i
// 时间复杂度O(n)
// 空间复杂度O(1)
public class Solution {
    /**
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate(int[] numbers) {
        // write code here
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] >= numbers.length) {
                return -1;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i])
                    return numbers[i];

                int t = numbers[i];
                numbers[i] = numbers[t];
                numbers[t] = t;
            }
        }
        return -1;
    }
}