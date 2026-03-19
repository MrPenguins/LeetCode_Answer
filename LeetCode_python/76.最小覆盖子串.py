import math
from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        s_table = defaultdict(int)
        t_table = defaultdict(int)

        for i in range(len(t)):
            t_table[t[i]] += 1

        left = 0
        match_cnt = 0
        max_match_cnt = len(t_table)
        min_sub_length = math.inf
        min_sub_index = None
        for right in range(len(s)):
            flag = False
            s_table[s[right]] += 1
            if s_table[s[right]] == t_table[s[right]]:
                match_cnt += 1
            while match_cnt == max_match_cnt:
                flag = True
                s_table[s[left]] -= 1
                if s_table[s[left]] == t_table[s[left]] - 1:
                    match_cnt -= 1
                left += 1
            if flag and right - left + 2 < min_sub_length:
                min_sub_length = right - left + 2
                min_sub_index = left - 1
        if min_sub_index is not None:
            return s[min_sub_index : min_sub_index + min_sub_length]
        else:
            return ""

if __name__ == "__main__":
    s = "a"
    t = "a"
    print(Solution().minWindow(s, t))