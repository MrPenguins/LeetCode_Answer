// 使用数组存储一对字符上次出现的位置，若不同则一定不是同构字符串
// 时间复杂度O(n)
// 空间复杂度O(k)，k为字符串的字符集大小

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] preShowIndexOfS = new int[256];
        int[] preShowIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (preShowIndexOfS[a] != preShowIndexOfT[b]) {
                return false;
            }
            preShowIndexOfS[a] = i + 1;
            preShowIndexOfT[b] = i + 1;
        }
        return true;
    }
}