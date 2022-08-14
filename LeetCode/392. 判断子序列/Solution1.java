// 时间复杂度O(n+m)
// 空间复杂度O(1)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int x = 0, y = 0;
        while (x < s.length() && y < t.length()) {
            if (s.charAt(x) == t.charAt(y)) {
                x++;
            }
            y++;
        }
        if (x == s.length()) {
            return true;
        }
        return false;
    }
}