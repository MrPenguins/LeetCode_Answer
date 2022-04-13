// bfs遍历所有同种颜色的相邻节点
// 时间复杂度O(n*m)
// 空间复杂度O(n*m) 主要为队列的开销

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int height = image.length;
        int width = image[0].length;
        int originColor = image[sr][sc];
        if (originColor == newColor) {
            return image;
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            image[cell[0]][cell[1]] = newColor;
            for (int[] direction : directions) {
                int x = cell[0] + direction[0];
                int y = cell[1] + direction[1];
                if (x >= 0 && y >= 0 && x < height && y < width && image[x][y] == originColor) {
                    queue.add(new int[]{x, y});
                }
            }
        }
        return image;
    }
}