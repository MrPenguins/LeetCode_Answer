// 字符串模拟大数解法

class Solution {
    private int[] output;
    int index;

    public int[] printNumbers(int n) {
        output = new int[(int) Math.pow(10, n) - 1];
        count = 0;
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (incrementNumber(number)) {
            printNumber(number);
        }
        return output;
    }

    boolean incrementNumber(char[] number) {
        int carry = 0;
        for (int i = 0; i < number.length; i++) {
            int current = number[i] - '0' + carry;
            if (i == 0) {
                current++;
            }
            if (current == 10) {
                if (i == number.length - 1) {
                    return false;
                } else {
                    number[i] = '0';
                    carry = 1;
                }
            } else {
                number[i] = (char) (current + '0');
                break;
            }
        }
        return true;
    }

    void printNumber(char[] number) {
        boolean startZero = true;
        StringBuilder s = new StringBuilder();
        for (int i = number.length - 1; i >= 0; i--) {
            char c = number[i];
            if (startZero && c != '0') {
                startZero = false;
            }
            if (!startZero) {
                s.append(c);
            }
        }
        output[count++] = Integer.parseInt(s.toString());
    }
}