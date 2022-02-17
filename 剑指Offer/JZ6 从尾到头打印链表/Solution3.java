import java.util.*;

// 递归解法，只需遍历一次链表, 相当巧妙的做法
// 时间复杂度O(n)
// 空间复杂度O(1) （如果不考虑输出使用的数组所占据的空间）

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    int[] ans;
    int length;

    public int[] reversePrint(ListNode head) {
        traverse(head, 0);
        return ans;
    }

    void traverse(ListNode cur, int count) {
        if (cur == null) {
            ans = new int[count];
            length = count - 1;
            return;
        }
        traverse(cur.next, count + 1);
        ans[length - count] = cur.val;
    }
}