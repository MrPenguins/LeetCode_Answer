// 每个元素向后移动k个，利用中间变量来记录位置被占用的那个元素，直至返回第一个移动的元素的位置
// 关键为如何确定需要移动几轮？
// 我们设n为数组长度，a为每轮移动经历的从头至尾的次数，b为每轮移动遍历的元素个数，我们有a*n=b*k
// 不难发现，a*n为n，k的最小公倍数，b=lcm(n,k)/k
// 移动的轮数就等于n/b=n*k/lcm(n,k)=gcd(n,k)
// 时间复杂度O(n)
// 空间复杂度O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k % = n;
        int count = gcd(n, k);
        for (int i = 0; i < count; i++) {
            int cur = i;
            int t = nums[i];
            do {
                cur = (cur + k) % n;
                int x = nums[cur];
                nums[cur] = t;
                t = x;
            } while (cur != i);
        }
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}