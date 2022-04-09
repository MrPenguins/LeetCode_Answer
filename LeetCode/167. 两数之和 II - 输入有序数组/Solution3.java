// 采用双指针的解法
// 开始时，让左指针指向下标为0的元素，右指针指向下标为n-1的元素
// 若两个元素的和小于target，左指针右移；若大于，右指针左移
// 因为一定是左指针或右指针先指向正确答案中的一个元素（排除初始化时就刚好指向正确答案的情况），之后另一个指针再向左或右单向移动，因此不会错过正确答案
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        while (sum != target) {
            if (sum < target) {
                left++;
            } else {
                right--;
            }
            sum = numbers[left] + numbers[right];
        }
        return new int[]{left + 1, right + 1};
    }
}