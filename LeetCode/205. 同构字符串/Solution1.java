// 需要注意多个键对同个值的情况
// 时间复杂度O(n)
// 空间复杂度O(k)，k为字符串的字符集大小

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else if (map.containsValue(b)) {
                return false;
            } else {
                map.put(a, b);
            }
        }
        return true;
    }
}