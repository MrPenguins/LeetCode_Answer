from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            if nums[i] <= 0:
                nums[i] = n + 1
        for i in range(n):
            x = abs(nums[i])
            if x <= n and nums[x - 1] > 0:
                nums[x - 1] = -nums[x - 1]
        for i in range(n):
            if nums[i] > 0:
                return i + 1
        return n + 1


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            while 0 < nums[i] <= n and nums[i] != nums[nums[i] - 1]:
                # 这句的前后顺序很关键，如果换成下面这句会TLE
                # nums[i], nums[nums[i] - 1] = nums[nums[i] - 1], nums[i]
                # 因为python的交换赋值会先计算右边的值，但在给左侧赋值时，是按从左到右的顺序赋值的
                # 因此如果把nums[i]放在左边，会导致nums[nums[i] - 1]的值被改变，从而影响交换的结果，导致死循环
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1
        return n + 1
