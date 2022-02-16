import java.util.*;

// 顺序遍历字符串中的每个字符，将空格在一个新的StringBuilder中替换为“%20”
// 实际上可以直接使用 str= s.replace(" ","%20"); 来达到目的
// 时间复杂度O(n)
// 空间复杂度O(n)
class Solution {
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}