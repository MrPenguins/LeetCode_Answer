from collections import defaultdict
from typing import List


# 注意数据范围，数组中包含负数，所以用滑动窗口会漏
# 一定要用hashmap，因为某个前缀和可能出现多次，所以要记录出现的次数
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hash_map = {0: 1}
        count = 0
        accu = 0
        for i in range(len(nums)):
            accu += nums[i]
            if (accu - k) in hash_map:
                count += hash_map[accu - k]
            hash_map[accu] = hash_map.get(accu, 0) + 1
        return count


# 这个解法太优雅了
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hash_map = defaultdict(int)
        sum = 0
        ans = 0
        for x in nums:
            hash_map[sum] += 1
            sum += x
            ans += hash_map[sum - k]
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.subarraySum([1, -1, 0], 0))
