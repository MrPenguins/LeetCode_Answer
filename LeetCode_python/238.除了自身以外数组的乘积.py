from typing import List

# 时间复杂度 O(n)，空间复杂度 O(1)
# ans数组记录左侧的乘积，right_product记录右侧的乘积，一次遍历即可
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        ans = [1 for _ in range(length)]
        for i in range(1, length):
            ans[i] = ans[i-1] * nums[i-1]
        right_product = nums[length - 1]
        for i in range(length-2, -1, -1):
            ans[i] *= right_product
            right_product *= nums[i]
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.productExceptSelf([1, 2]))