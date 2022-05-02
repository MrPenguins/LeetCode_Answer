// 使用递归，在每个对于每个数字，均考虑两种情况：选与不选
// 复杂度分析见 https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/

class Solution1 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> path = new Stack<>();
        search(1, path, n, k);
        return ans;
    }

    public void search(int start, Stack<Integer> path, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (start > n - k + 1) {
            return;
        }
        search(start + 1, path, n, k);
        path.push(start);
        search(start + 1, path, n, k - 1);
        path.pop();
    }
}