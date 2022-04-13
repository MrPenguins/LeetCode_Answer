// dfs遍历所有同种颜色的相邻节点
// 时间复杂度O(n*m)
// 空间复杂度O(n*m) 主要为栈的开销

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int height = image.length;
        int width = image[0].length;
        int originColor = image[sr][sc];
        paint(image, sr, sc, newColor, originColor, height, width);
        return image;
    }

    public void paint(int[][] image, int x, int y, int newColor, int originColor, int height, int width) {
        if (x < 0 || y < 0 || x >= height || y >= width || image[x][y] != originColor || newColor == originColor) {
            return;
        }
        image[x][y] = newColor;
        paint(image, x - 1, y, newColor, originColor, height, width);
        paint(image, x + 1, y, newColor, originColor, height, width);
        paint(image, x, y - 1, newColor, originColor, height, width);
        paint(image, x, y + 1, newColor, originColor, height, width);
    }
}