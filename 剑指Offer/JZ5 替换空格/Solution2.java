import java.util.*;

// 剑指offer中的做法，先计算出原字符串中空格的个数，然后利用双指针从后往前替换原字符串中的字符
// 由于cpp可以直接使用原字符串之后的空间，故这样的做法能让空间复杂度降为O(1)
// 对于java来说，这样的意义不大
// 本题关键点有两个：双指针与从后往前
// 时间复杂度O(n)
// 空间复杂度O(n)
class Solution {
    public String replaceSpace(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                count++;
            }
        }
        char[] result = new char[charArray.length + 2 * count];
        int index = result.length - 1;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                result[index--] = '0';
                result[index--] = '2';
                result[index--] = '%';
            } else {
                result[index--] = charArray[i];
            }
        }
        return new String(result);
    }
}