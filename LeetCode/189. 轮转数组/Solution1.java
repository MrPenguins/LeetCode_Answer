// 利用额外的数组来储存
// 时间复杂度O(n)
// 空间复杂度O(n)

class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 以下两行可以优化为：
            // ans[(i + k) % nums.length] = nums[i];
            int index = i + k >= nums.length ? (i + k) % nums.length : i + k;
            ans[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }
}