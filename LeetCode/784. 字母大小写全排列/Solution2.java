// 这种解法会在每个字母处改变其大小写，进入下一轮递归
// 利用异或0010 0000来进行大小写转换的思路非常精妙
// 关键在于利用了大小写差值为32的性质，而利用异或可以进行无符号加法，也就相当于对应情况的加减法

class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] charArray = s.toCharArray();
        dfs(0, charArray);
        return ans;
    }

    private void dfs(int index, char[] charArray) {
        if (index == charArray.length) {
            ans.add(new String(charArray));
            return;
        }

        dfs(index + 1, charArray);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            // 因为这种情况不会回溯，所以不需要复原
            dfs(index + 1, charArray);
        }
    }
}