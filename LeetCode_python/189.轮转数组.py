from typing import List


# 使用了额外的数组来存储旋转后的结果，空间复杂度为 O(n)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        k = k % length
        ans = list(range(length))
        for i in range(length):
            ans[(i + k) % length] = nums[i]
        for i in range(length):
            nums[i] = ans[i]


# 使用三次翻转，空间复杂度为 O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        k = k % length
        for i in range(length // 2):
            nums[i], nums[length - 1 - i] = nums[length - 1 - i], nums[i]
        for i in range(k // 2):
            nums[i], nums[k - 1 - i] = nums[k - 1 - i], nums[i]
        for i in range(k, (length + k) // 2):
            nums[i], nums[length - i + k - 1] = nums[length - i + k - 1], nums[i]


# 使用环状替换，空间复杂度为 O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        k = k % length
        cnt = 0
        start = 0
        while cnt < length:
            cur = start
            prev_num = nums[cur]
            while True:
                cur = (cur + k) % length
                prev_num, nums[cur] = nums[cur], prev_num
                cnt += 1
                if cur == start:
                    break
            start += 1


if __name__ == '__main__':
    s = Solution()
    nums = [1, 2, 3, 4, 5]
    k = 3
    print(s.rotate(nums, k))
