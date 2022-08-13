// 动态规划，构建f数组，记录对于t每个位置，下次出现某个字符的下标
// 之后就可以使用该数组快速得到下次出现的位置
// 时间复杂度O(m*∣Σ∣+n)，判断子序列时间为O(n)，其余为构建数组的开销
// 空间复杂度O(m*∣Σ∣)，动态规划数组的开销

class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] f = new int[n + 1][26];
        for (int i = 0; i < 26; i++) {
            f[n][i] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int next = 0;
        for (int i = 0; i < m; i++) {
            if (f[next][s.charAt(i) - 'a'] == n) {
                return false;
            }
            next = f[next][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}