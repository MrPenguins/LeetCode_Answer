from collections import defaultdict
from typing import List


# 设定 N 为字符串数组 strs 的长度，K 为字符串的最大长度。
# O(N * K + N^2)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hash_map_list = []
        answer_list = []
        for string in strs:
            flag = True
            temp_map = {}
            for c in string:
                temp_map[c] = temp_map.get(c, 0) + 1
            for hash_map, answer in zip(hash_map_list, answer_list):
                if temp_map == hash_map:
                    answer.append(string)
                    flag = False
                    break
            if flag:
                hash_map_list.append(temp_map)
                answer_list.append([string])
        return answer_list


# O(N * K log K)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_map = defaultdict(list)
        for s in strs:
            key = tuple(sorted(s))
            anagram_map[key].append(s)
        return list(anagram_map.values())


# O(N * K)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_map = defaultdict(list)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            key = tuple(count)
            anagram_map[key].append(s)
        return list(anagram_map.values())
