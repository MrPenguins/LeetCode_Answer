// M,N 分别为矩阵行列大小，K为字符串 word 长度
// 时间复杂度O((3^K)*MN),最差情况，对于每个起点，都需要遍历所有情况。
// 对于每次递归，共有三种选择（上下左右中除去上一轮选择的方向），复杂度O(3^K)，共MN个起点
// 空间复杂度O(K)，递归深度不超过K

class Solution {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (findWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean findWord(char[][] board, String word, int pathLength, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(pathLength)) {
            return false;
        }
        if (pathLength == word.length() - 1) {
            return true;
        }
        board[x][y] = '\0';
        boolean result = findWord(board, word, pathLength + 1, x - 1, y) || findWord(board, word, pathLength + 1, x + 1, y) || findWord(board, word, pathLength + 1, x, y - 1) || findWord(board, word, pathLength + 1, x, y + 1);
        board[x][y] = word.charAt(pathLength);
        return result;
    }
}