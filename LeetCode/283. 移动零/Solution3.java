// 这种解法运用了快排交换的思想
// 我们需要将0移动到数组的末尾，将其他元素位置不变地移动到数组的前面
// 用i依次遍历数组，j记录数组已经整理好的部分，即从0到i中非零的元素
// 因此从j到i-1，一定全为零（i和j不相等的情况下）
// 所以每次将下标为i的非零数与下标为j的0交换，即可完成任务（因为下标为j的数一定为0，故可以直接赋值，简化计算）
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution3 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}