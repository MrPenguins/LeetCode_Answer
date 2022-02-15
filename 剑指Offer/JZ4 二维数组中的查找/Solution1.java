import java.util.*;

// 采用剑指Offer上的方法，每次选取数组右上角的数与目标比较，若相等，则找到目标数
// 若更大，则删去该列；若更小，则删去该行
// 也可选择数组左下角的数作比较
// “我们将矩阵逆时针旋转 45° ，并将其转化为图形式，发现其类似于 二叉搜索树 ，即对于每个元素，其左分支元素更小、右分支元素更大。” 这位大佬的阐述相当形象易懂，链接如下：
// https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
// 时间复杂度 O(m+n)，m、n为行数和列数
// 空间复杂度 O(1)
// 第一次fail，未考虑数组为空的情况，导致空指针
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length > 0 && matrix[0].length > 0) {
            int row = 0, col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }
        }
        return false;
    }
}