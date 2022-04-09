// 暴力解法，没有利用数组有序的性质
// 时间复杂度O(n^2)
// 空间复杂度O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    return ans;
                }
            }
        }
        return ans;
    }
}