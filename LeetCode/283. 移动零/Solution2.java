// 遍历数组，count记录遇到的0的个数，每次将遇到的非0数前移count位
// 因为末尾的元素一定是0，因此本题我们不需要交换，直接在末尾补0就可以了
// 一种更加优雅的写法 https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            nums[i - count] = nums[i];
        }
        for (int i = 0; i < count; i++) {
            nums[n - i - 1] = 0;
        }
    }
}