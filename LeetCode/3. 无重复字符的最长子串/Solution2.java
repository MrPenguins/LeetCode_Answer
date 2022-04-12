// 利用HashMap，一种更加优雅的解法
// 记录窗口中元素的下标，依据此下标来判断元素是否还在窗口中
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> stat = new HashMap<>();
        int head = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (stat.containsKey(x)) {
                head = Math.max(head, stat.get(x) + 1);
            }
            maxLength = Math.max(maxLength, i - head + 1);
            stat.put(x, i);
        }
        return maxLength;
    }
}