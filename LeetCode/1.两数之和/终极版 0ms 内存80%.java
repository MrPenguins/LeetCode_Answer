class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        //一次判断两个数，这是怎么想出来的，NB
        for (int i = 0; i <= nums.length / 2; i++) {
            if (record.containsKey(nums[i])) {
                ans[0] = i;
                ans[1] = record.get(nums[i]);
                break;
            }
            // 存target减后对应的数，能够在一次循环中完成
            record.put(target - nums[i], i);
            if (record.containsKey(nums[nums.length - 1 - i])) {
                ans[0] = nums.length - 1 - i;
                ans[1] = record.get(nums[nums.length - 1 - i]);
                break;
            }
            record.put(target - nums[nums.length - 1 - i], nums.length - 1 - i);
        }
        return ans;
    }
}