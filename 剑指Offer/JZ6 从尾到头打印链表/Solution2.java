import java.util.*;

// 获取链表长度后，逆序填充至数组中
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
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int[] ans = new int[length];
        cur = head;
        while (cur != null) {
            ans[--length] = cur.val;
            cur = cur.next;
        }
        return ans;
    }
}