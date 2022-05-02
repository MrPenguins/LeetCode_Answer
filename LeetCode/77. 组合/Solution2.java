// 回溯法，每次会在起始位置到终点的所有可能位置选择一个数，并从那个数之后开始下一轮搜素

class Solution2 {
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
        for (int i = start; i <= n - k + 1; i++) {
            path.push(i);
            search(i + 1, path, n, k - 1);
            path.pop();
        }
    }
}