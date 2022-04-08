// 不利用额外的数组来储存，每次只右移一位
// 时间复杂度O(n*k)，过高，tle
// 空间复杂度O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int t = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                int x = nums[j];
                nums[j] = t;
                t = x;
            }
        }
    }
}