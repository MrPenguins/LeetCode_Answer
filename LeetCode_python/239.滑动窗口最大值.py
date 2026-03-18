from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        index_list = []
        for i in range(len(nums)):
            while len(dq) >= 1 and nums[i] > nums[dq[-1]]:
                dq.pop()
            dq.append(i)
            if dq[0] < i - k + 1:
                dq.popleft()
            if i >= k - 1:
                index_list.append(dq[0])
        ans = []
        for index in index_list:
            ans.append(nums[index])
        return ans


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        ans = []
        for i in range(len(nums)):
            while dq and nums[i] > nums[dq[-1]]:
                dq.pop()
            dq.append(i)
            if dq[0] < i - k + 1:
                dq.popleft()
            if i >= k - 1:
                ans.append(nums[dq[0]])
        return ans
