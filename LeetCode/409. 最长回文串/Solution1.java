// 时间复杂度O(n)
// 空间复杂度O(s)，s为字符集的大小，该解法下为128

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean hasOdd = false;
        for (int i = 'A'; i <= 'z'; i++) {
            if (count[i] % 2 == 0) {
                ans += count[i];
            } else {
                hasOdd = true;
                ans += count[i] - 1;
            }
        }
        if (hasOdd) {
            ans++;
        }
        return ans;
    }
}