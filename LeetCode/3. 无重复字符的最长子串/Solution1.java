// 滑动窗口，用一个数组记录窗口内出现了哪些字符
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] stat = new int[128];
        int head = 0;
        int maxLength = 1;
        if (s.length() == 0) {
            return 0;
        }
        int i;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stat[(int) c] == 1) {
                if (maxLength < i - head) {
                    maxLength = i - head;
                }
                while (head < i) {
                    stat[(int) s.charAt(head)]--;
                    if (s.charAt(head) == c) {
                        head++;
                        break;
                    }
                    head++;
                }
            }
            stat[(int) c]++;
        }
        if (maxLength < i - head) {
            maxLength = i - head;
        }
        return maxLength;
    }
}