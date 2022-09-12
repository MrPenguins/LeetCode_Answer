// 全排列解法
// 时间复杂度O(10^n)
// 空间复杂度O(10^n)

class Solution {
    private int[] output;
    int count;

    public int[] printNumbers(int n) {
        output = new int[(int) Math.pow(10, n) - 1];
        count = 0;
        for (int i = 1; i <= n; i++) {
            for (char first = '1'; first <= '9'; first++) {
                char[] number = new char[i];
                number[0] = first;
                dfs(number, i, 1);
            }
        }
        return output;
    }

    void dfs(char[] number, int digit, int index) {
        if (index == digit) {
            output[count++] = Integer.parseInt(String.valueOf(number));
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            number[index] = i;
            dfs(number, digit, index + 1);
        }
    }
}