from collections import defaultdict
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        p_table = defaultdict(int)
        sub_table = defaultdict(int)
        p_length = len(p)

        ans = []
        for i in range(p_length):
            p_table[p[i]] += 1

        match_cnt = 0
        max_match_cnt = len(p_table)
        for i in range(len(s)):
            sub_table[s[i]] += 1
            if sub_table[s[i]] == p_table[s[i]]:
                match_cnt += 1
            elif sub_table[s[i]] == p_table[s[i]] + 1:
                match_cnt -= 1
            if i >= p_length:
                sub_table[s[i - p_length]] -= 1
                if sub_table[s[i - p_length]] == p_table[s[i - p_length]]:
                    match_cnt += 1
                elif sub_table[s[i - p_length]] == p_table[s[i - p_length]] - 1:
                    match_cnt -= 1
            if match_cnt == max_match_cnt:
                ans.append(i - p_length + 1)
        return ans
