class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(nums[i])) {
                ans[0] = i;
                ans[1] = record.get(nums[i]);
                break;
            }
            // 存target减后对应的数，能够在一次循环中完成
            record.put(target - nums[i], i);
        }
        return ans;
    }
}