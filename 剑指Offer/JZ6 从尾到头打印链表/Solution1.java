import java.util.*;

// 利用栈储存链表中的元素，完成反序输出
// 时间复杂度O(n)
// 空间复杂度O(n)

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
        Stack stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index++] = (int) stack.pop();
        }
        return ans;
    }
}