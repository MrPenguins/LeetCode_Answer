// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int left = 0, right = sum - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (left == right) {
                return i;
            }
            left += nums[i];
            right -= nums[i + 1];
        }
        if (sum - nums[nums.length - 1] == 0) {
            return nums.length - 1;
        }
        return -1;
    }
}