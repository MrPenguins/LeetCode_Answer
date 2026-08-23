from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        m = len(matrix)
        n = len(matrix[0])
        top = 0
        bottom = m - 1
        left = 0
        right = n - 1
        ans = []
        while top <= bottom and left <= right:
            for j in range(left, right + 1):
                ans.append(matrix[top][j])
            top += 1
            if top <= bottom:
                for i in range(top, bottom + 1):
                    ans.append(matrix[i][right])
                right -= 1
            else:
                break
            if left <= right:
                for j in range(right, left - 1, -1):
                    ans.append(matrix[bottom][j])
                bottom -= 1
            else:
                break
            if top <= bottom:
                for i in range(bottom, top - 1, -1):
                    ans.append(matrix[i][left])
                left += 1
            else:
                break
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
