// 该题采用双指针的做法
// 如果直接用双指针指向负数与非负数的分界处，需要考虑各种复杂的边界情况，如数组中不含负数，数组长度为1等，代码较为繁琐
// 因此采用左指针指向下标为0处，右指针指向下标为n-1处，有后向前填充答案数组，就无需考虑上述的复杂情况

class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[i] = nums[left] * nums[left];
                left++;
            } else {
                ans[i] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}