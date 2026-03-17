from typing import List


# O(n)，先找到最高的柱子，然后分别从两侧向最高柱子遍历，计算积水量
class Solution:
    def trap(self, height: List[int]) -> int:
        length = len(height)
        max_height = 0
        max_index = 0
        ans = 0
        for i in range(length):
            if height[i] > max_height:
                max_height = height[i]
                max_index = i

        # 计算左侧
        left = 0
        while left < max_index:
            right = left + 1
            rock = 0
            while height[right] < height[left]:
                rock += height[right]
                right += 1
            ans += (right - left - 1) * height[left] - rock
            left = right

        # 计算右侧
        right = length - 1
        while right > max_index:
            left = right - 1
            rock = 0
            while height[left] < height[right]:
                rock += height[left]
                left -= 1
            ans += (right - left - 1) * height[right] - rock
            right = left
        return ans


# O(n)，双指针，left和right分别从两侧向中间遍历，left_max和right_max分别记录当前left和right位置的最高柱子高度
class Solution:
    def trap(self, height: List[int]) -> int:
        length = len(height)
        left = 0
        right = length - 1
        left_max = 0
        right_max = 0
        ans = 0
        while left < right:
            left_max = max(height[left], left_max)
            right_max = max(height[right], right_max)
            if height[left] < height[right]:
                ans += left_max - height[left]
                left += 1
            else:
                ans += right_max - height[right]
                right -= 1
        return ans
