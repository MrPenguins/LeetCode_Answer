// https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution/55849
// https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution/1090065
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    // 翻转从left到right之间的所有元素，包括left与right
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}