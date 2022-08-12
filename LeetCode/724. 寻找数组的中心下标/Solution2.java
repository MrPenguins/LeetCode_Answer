// 更优雅的解法
// 时间复杂度O(n)
// 空间复杂度O(1)

import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }
}
