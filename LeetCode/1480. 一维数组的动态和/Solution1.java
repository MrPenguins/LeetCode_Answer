// 时间复杂度O(n)
// 空间复杂度O(n)

class Solution {
    public int[] runningSum(int[] nums) {
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
        }
        return nums;
    }
}