// dp，由于某个节点到0的最短距离一定是0（该节点本身为0）或其上下左右四个方向中到0的最下距离加1，因此可以采用动态规划
// 先将所有非0节点的值置为无穷大（注意不能为Integer.MAX_VALUE，会溢出）
// 然后依次从左上与右下两个方向更新所有节点距离0的最小值，即可得到正确答案
// 时间复杂度O(m*n)
// 空间复杂度O(1)

class Solution2 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        // 左上
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1) {
                    mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);
                }
                if (j >= 1) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
                }
            }
        }
        // 右下
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i <= m - 2) {
                    mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                }
                if (j <= n - 2) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                }
            }
        }
        return mat;
    }
}