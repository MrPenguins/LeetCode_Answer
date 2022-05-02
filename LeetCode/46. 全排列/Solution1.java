// 回溯算法，利用used数组标记某个位置的数字是否已被使用
// 依次挑选所有未使用的数字，进入下一轮递归
// 时间复杂度O(n*n!)
// 空间复杂度O(n)
// 这份题解非常详细：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/

class Solution1 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(), nums, used);
        return ans;
    }

    public void dfs(List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                tmp.add(nums[i]);
                used[i] = true;
                dfs(tmp, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}