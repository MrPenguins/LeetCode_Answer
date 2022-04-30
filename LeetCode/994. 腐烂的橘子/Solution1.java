// bfs，先将所有腐烂的橘子入队，同时统计新鲜橘子的数量
// 之后每一轮将队列中的所有烂橘子出队，每个烂橘子出队时都会污染四周的新鲜橘子，将被污染的橘子入队，同时更新新鲜橘子数量
// 队列为空时判断剩余新鲜橘子的数量
// 时间复杂度O(m*n)
// 空间复杂度O(m*n)

class Solution1 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] node = queue.poll();
                int x0 = node[0];
                int y0 = node[1];
                for (int i = 0; i < 4; i++) {
                    int x1 = x0 + directions[i][0];
                    int y1 = y0 + directions[i][1];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == 1) {
                        grid[x1][y1] = 2;
                        fresh--;
                        queue.offer(new int[]{x1, y1});
                    }
                }
                size--;
            }
            count++;
        }
        if (fresh == 0) {
            return count;
        } else {
            return -1;
        }
    }
}