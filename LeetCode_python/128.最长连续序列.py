from typing import List


# O(n^2)
# case: nums = [1, 1, 1, 1, ..., 1, 2, 3, 4, ..., 1000]
# 因为遍历的是nums，其中可能有大量的重复数字都能作为一个长序列的起点
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        max_length = 0
        hash_set = set()
        for num in nums:
            hash_set.add(num)
        for num in nums:
            if num - 1 in hash_set:
                continue
            length = 1
            while num + 1 in hash_set:
                length += 1
                num += 1
            if length > max_length:
                max_length = length
        return max_length

# O(n)
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        max_length = 0
        hash_set = set(nums)
        for num in hash_set:
            if num - 1 not in hash_set:
                length = 1
                while num + length in hash_set:
                    length += 1
                if length > max_length:
                    max_length = length
        return max_length