// 双指针法，非常巧妙
// 我们利用cnt来记录s2的区间中缺少的字母数量
// 时间复杂度O(n+m)
// 空间复杂度O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m < n) {
            return false;
        }
        int[] cnt = new int[26];
        // 先统计s1中所有的字母数量，确保cnt中的每个元素小于等于零
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        // 我们依次固定右端点，在每轮循环开始的时候，我们都保证cnt中的每个元素小于等于零
        for (int right = 0; right < m; right++) {
            int x = s2.charAt(right) - 'a';
            // 增加右端点的字母的数字，此时cnt[x]最大为1
            cnt[x]++;
            // 右移左端点，直到cnt[x]为0
            // 这里我们不需要加入left<=right的条件，因为当左端点与右端点重合的时候，自然满足cnt[x]=0
            while (cnt[x] > 0) {
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }
            // 当左右指针之间的长度等于n时，即找到了满足条件的解
            // 因为cnt中的每个元素小于等于零（除了cnt[x]），所以我们不需要担心出现cnt[x]等于零但有其他元素不等于0的情况
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}