// 快慢指针法求解，只需要遍历链表一次
// 时间复杂度O(n)
// 空间复杂度O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode i = head;
        ListNode j = head;
        int count = 0;
        while (j.next != null) {
            j = j.next;
            if (count % 2 == 0) {
                i = i.next;
            }
            count++;
        }
        return i;
    }
}