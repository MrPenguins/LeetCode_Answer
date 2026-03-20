import math
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_sum = nums[0]
        max_sum = nums[0]
        min_sum = min(0, nums[0])
        for i in range(1, len(nums)):
            cur_sum += nums[i]
            if cur_sum - min_sum > max_sum:
                max_sum = cur_sum - min_sum
            if cur_sum < min_sum:
                min_sum = cur_sum
        return max_sum


# 如果前面的累加和已经是负数了，那加上只会拖累自己，不如从当前元素重新开始计算。
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_sum = 0
        max_sum = -math.inf
        for num in nums:
            cur_sum = max(cur_sum + num, num)
            max_sum = max(max_sum, cur_sum)
        return max_sum


# 分治
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        def get_info(l: int, r: int):
            if l == r:
                return nums[l], nums[l], nums[l], nums[l]
            m = (l + r) // 2
            l_i_sum, l_l_sum, l_r_sum, l_max_sum = get_info(l, m)
            r_i_sum, r_l_sum, r_r_sum, r_max_sum = get_info(m + 1, r)

            c_i_sum = l_i_sum + r_i_sum
            c_l_sum = max(l_l_sum, l_i_sum + r_l_sum)
            c_r_sum = max(r_r_sum, l_r_sum + r_i_sum)
            c_max_sum = max(l_max_sum, r_max_sum, l_r_sum + r_l_sum)

            return c_i_sum, c_l_sum, c_r_sum, c_max_sum

        return get_info(0, len(nums) - 1)[3]
