// 采用类似冒泡排序的方法，从后往前，将遇到的每一个0逐渐“浮到”数组末尾
// 时间复杂度O(n^2)
// 空间复杂度O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n - 1 && nums[j + 1] != 0) {
                    nums[j] = nums[j + 1];
                    j++;
                }
                nums[j] = 0;
            }
        }
    }
}