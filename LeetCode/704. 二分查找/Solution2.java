class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {    // 和之前的版本相比，多加了一个判断和break，可以更快的判断出target是否在数组中
                right = mid - 1;
            }else {
                break;
            }
        }
        return -1;
    }
}