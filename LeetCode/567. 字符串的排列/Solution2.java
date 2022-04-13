// 对Solution1的优化
// 之前我们每次移动滑动窗口，只改变了两个字母，却比较了整个数组
// 现在我们只使用一个数组，用来记录两个字符串之间的差异
// 引入diff来记录差异的个数
// 根据移动窗口时进入离开的字母是否会使某个字母的差异数为0来增减diff
// 时间复杂度O(n+m)
// 空间复杂度O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m < n) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int x : cnt) {
            if (x != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; i++) {
            int x = s2.charAt(i - n) - 'a';
            int y = s2.charAt(i) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                diff++;
            }
            cnt[x]++;
            if (cnt[x] == 0) {
                diff--;
            }
            if (cnt[y] == 0) {
                diff++;
            }
            cnt[y]--;
            if (cnt[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}