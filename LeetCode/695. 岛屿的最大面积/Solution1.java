// 本题巧妙之处在于将计算过的岛屿置为零，就可以避免对其进行重复计算
// dfs，运用递归完成
// 题解改变的原数组的值，如不想改变则需要复制一份
// 时间复杂度O(n*m)
// 空间复杂度O(n*m)

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int count = 1;
        count += dfs(grid, x + 1, y);
        count += dfs(grid, x - 1, y);
        count += dfs(grid, x, y + 1);
        count += dfs(grid, x, y - 1);
        return count;
    }
}