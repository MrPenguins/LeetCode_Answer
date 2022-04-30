// bfs，先遍历矩阵，将所有值为0的节点加入队列，将值为1的节点置为-1，代表尚未访问
// 不断从队列中取出元素，遍历其上下左右四个方向的节点，更新尚未访问的节点的值，同时将其加入队列
// 时间复杂度O(m*n)
// 空间复杂度O(m*n)

class Solution1 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    // 将未遍历的点的值置为-1
                    mat[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x0 = node[0];
            int y0 = node[1];
            for (int i = 0; i < 4; i++) {
                int x1 = x0 + directions[i][0];
                int y1 = y0 + directions[i][1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && mat[x1][y1] == -1) {
                    mat[x1][y1] = mat[x0][y0] + 1;
                    queue.offer(new int[]{x1, y1});
                }
            }
        }
        return mat;
    }
}