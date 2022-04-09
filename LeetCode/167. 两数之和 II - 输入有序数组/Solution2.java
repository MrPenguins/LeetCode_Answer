// 在查找每个元素是否有匹配元素时，在右侧进行二分查找
// 时间复杂度O(n log n)
// 空间复杂度O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = target - numbers[i];
            int index = binarySearch(numbers, diff, i + 1, numbers.length - 1);
            if (index != -1) {
                ans[0] = i + 1;
                ans[1] = index + 1;
                return ans;
            }
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}