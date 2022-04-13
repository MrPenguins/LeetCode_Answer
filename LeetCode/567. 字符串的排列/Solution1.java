// 本题的关键为，若在s2的某个区间内，与s1中各个字母出现的次数相同，则s2包含s1的排列
// 因此可以用一个滑动窗口统计s2各个区间内的字母出现次数，并与s1的总体情况相比较
// n，m分别为两个字符串长度
// 时间复杂度O(n*m)
// 空间复杂度O(1) 即字符表的长度

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            cnt2[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) {
                cnt2[s2.charAt(i - s1.length()) - 'a']--;
            }
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}