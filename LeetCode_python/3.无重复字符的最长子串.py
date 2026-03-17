class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hash_set = set()
        left = 0
        right = 0
        max_length = 0
        cur_length = 0
        while right < len(s):
            if s[right] not in hash_set:
                hash_set.add(s[right])
                right += 1
                cur_length += 1
            else:
                max_length = max(max_length, cur_length)
                while left < right:
                    hash_set.remove(s[left])
                    left += 1
                    cur_length -= 1
                    if s[left - 1] == s[right]:
                        break
        return max(max_length, cur_length)


# 更优雅的写法
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hash_set = set()
        left = 0
        max_length = 0
        for right in range(len(s)):
            while s[right] in hash_set:
                hash_set.remove(s[left])
                left += 1
            hash_set.add(s[right])
            max_length = max(max_length, right - left + 1)
        return max_length
