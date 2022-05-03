// 回溯法

class Solution1 {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        dfs(0, sb);
        return ans;
    }

    public void dfs(int index, StringBuilder sb) {
        // 因为我们每改变任意一个字符的大小写，都会产生一个新的解，所以需要直接添加进答案
        ans.add(sb.toString());

        for (int i = index; i < sb.length(); i++) {
            char x = sb.charAt(i);
            if (x >= 97 && x <= 122) {
                sb.replace(i, i + 1, new String(String.valueOf(x).toUpperCase()));
                dfs(i + 1, sb);
                sb.replace(i, i + 1, new String(String.valueOf(x)));
            }
        }
    }
}