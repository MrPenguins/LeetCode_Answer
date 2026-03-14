from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = 0
        length = len(nums)
        while i < length:
            if i == j:
                j = i + 1
            if nums[i] == 0:
                while j < length and nums[j] == 0:
                    j += 1
                if j >= length:
                    break
                nums[i] = nums[j]
                nums[j] = 0
                i += 1
            else:
                i += 1


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # right 遍历整个数组，寻找非零元素
        # left 表示下个非零元素应该存放的位置
        left = 0
        for right in range(len(nums)):
            if nums[right] != 0:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
