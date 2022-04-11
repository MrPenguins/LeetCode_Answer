// 在对链表进行操作时，可以在头节点之前添加一个哑节点（dummy node）
// 这样就无需对头节点进行特殊判断
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode i = dummy;
        ListNode j = head;
        int count = n - 1;
        while (j.next != null) {
            j = j.next;
            if (count > 0) {
                count--;
                continue;
            }
            i = i.next;
        }
        i.next = i.next.next;
        return dummy.next;
    }
}