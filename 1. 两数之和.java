class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (record.containsKey(target - nums[i])) {
                if (record.get(target - nums[i]) == i) {
                    continue;
                }
                ans[0] = i;
                ans[1] = record.get(target - nums[i]);
                break;
            }
        }
        return ans;
    }
}