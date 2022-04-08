# LeetCode 189. 轮转数组

题目链接：[LeetCode 189. 轮转数组](https://leetcode-cn.com/problems/rotate-array/)

今天刷到此题，觉得三次翻转数组的解法巧妙无比，但难以理解，于是在LeetCode国际版上找到了从数学上证明的方法，毛遂顿开。心想着不妨整理一下本题的各种解法，也希望能为朋友们带来一点微不足道的帮助。

***

## 解法1：引入额外的数组

设`n`代表数组长度，则原数组下标为`i`的元素需要移动到下标为`(i+k) mod n`的位置。

* 时间复杂度：`O(n)`。

* 空间复杂度：`O(n)`。

参考代码（java）：

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }
}
```

***

## 解法2：每次右移一位，总共右移k轮

不使用额外的数组，每个元素每次只右移一位，共右移`k`轮。

* 时间复杂度：`O(n*k)`，过高，超时。

* 空间复杂度：`O(1)`。

参考代码（java）：

```java
class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int t = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                int x = nums[j];
                nums[j] = t;
                t = x;
            }
        }
    }
}
```

***

## 解法3：每次右移k位

我们每次将数组中的元素右移`k`位，则原数组下标为`i`的元素需要移动到下标为`(i+k) mod n`的位置。我们利用一个中间变量来记录下标为`(i+k) mod n`的元素，再将其右移`k`位，以此类推，直至某个元素右移之后的位置回到了`i`。我们将这样的操作称之为移动一轮。

那么我们应该如何确定需要移动几轮？

* 设`n`为数组长度，`a`为每轮移动经历的从头至尾的次数，`b`为每轮移动遍历的元素个数
* 如`n=6,k=4`，则`a=2,b=3`
* 易得$a*n=b*k$，等式两边的值都等于每轮移动“跨越”的元素数量
* 因为第一次回到初始位置时，该轮移动就停止了，所以$a*n$为n，k的最小公倍数，$b=\frac {lcm(n,k)} k$
* 因此，需要移动的轮数为$\frac{n}{b} = \frac{n}{\frac {lcm(n,k)} k} = \frac{n*k}{lcm(n,k)} = gcd(n,k)$，即为`n`，`k`的最大公约数

在下一轮移动开始时，我们只需要把起始位置设置为`i+1`即可。

* 时间复杂度：`O(n)`。

* 空间复杂度：`O(1)`。

参考代码（java）：

```java
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
```

***

## 解法4：三次翻转数组

我们先令`k %= n;`，确保$k<n$。

这种解法我们需要翻转数组三次：

1. 翻转整个数组
2. 翻转数组`[0,k-1]`
3. 翻转数组`[k,n-1]`

三次翻转之后，就相当于数组右移了`k`位，相当神奇。

下面给出数学上的证明方法：（注意，我们已经确保$k<n$）

1. 对于这个将整个数组右移`k`位的任务，我们可以将这个数组分为两部分：

   * 第一部分：`[0,n-k-1]`，这一部分的元素只需右移`k`位。对于下标为`i`的元素，移动后的下标为`i+k`。
   * 第二部分：`[n-k,n-1]`，这一部分的元素会移动到数组的开头。对于下标为`i`的元素，移动后的下标为`i+k-n`。

2. 对于所有的元素，经历了第一次翻转之后，其下标会由`i`变为`n-i-1`，两部分元素的范围会发生如下变化（用`n-i-1`替换原来的`i`）：

   * 第一部分：由`[0,n-k-1]`变为 `[n-(n-k-1)-1,n-1]`, 即`[k,n-1]`，注意左右边界发生了翻转。

   * 第二部分：由`[n-k,n-1]`变为`[0,k-1]`。

3. 对于第二部分的元素，经历第二次翻转后，其下标会由`j`变为`k-j-1`。注意，这里的`j`等于`n-i-1`。因此，反转后第二部分的元素的下标会变为`k-(n-i-1)-1=k-n+i=i+k-n`，完成了右移`k`位的任务。

4. 对于第一部分的元素，经历第二次翻转后，其下标会由`k+j`变为`k+(n-k-1-j)`。注意，这里的`k+j`等于`n-i-1`。因此，反转后第一部分的元素的下标会变为`k+(n-1-(k+j))=k+(n-1-n+i+1)=i+k`，完成了右移`k`位的任务。

* 时间复杂度：`O(n)`。

* 空间复杂度：`O(1)`。

参考代码（java）：

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    // 翻转从left到right之间的所有元素，包括left与right
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
```

***

参考资料：

LeetCode官方题解：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/

LeetCode国际版上的证明：https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution/55849

对上一条证明的补充：https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution/1090065

