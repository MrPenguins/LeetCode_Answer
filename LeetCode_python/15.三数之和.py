from collections import defaultdict


# TLE
# 理论是 O(N^2)，但未去重，实际常数过大，导致超时
class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        ans = defaultdict(list)
        length = len(nums)
        for i in range(length):
            hash_map = {}
            for j in range(i + 1, length):
                if (-nums[i] - nums[j]) in hash_map:
                    key = tuple(sorted([nums[i], nums[j], -nums[i] - nums[j]]))
                    ans[key] = [nums[i], nums[j], -nums[i] - nums[j]]
                hash_map[nums[j]] = j
        return list(ans.values())


# O(N^2)，排序 + 双指针
class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        length = len(nums)
        nums.sort()
        ans = []
        for a in range(length):
            if nums[a] > 0:
                break
            if a > 0 and nums[a - 1] == nums[a]:
                continue
            b, c = a + 1, length - 1
            while b < c:
                if nums[a] + nums[b] + nums[c] < 0:
                    b += 1
                    continue
                elif nums[a] + nums[b] + nums[c] > 0:
                    c -= 1
                    continue
                else:
                    ans.append([nums[a], nums[b], nums[c]])
                while b < c and nums[b] == nums[b + 1]:
                    b += 1
                while b < c and nums[c] == nums[c - 1]:
                    c -= 1
                b += 1
                c -= 1
        return ans
