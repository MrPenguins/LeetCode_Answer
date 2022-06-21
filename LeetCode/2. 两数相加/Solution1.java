// 需要注意的点有，加法最终的位数可能会比两个加数中较长的那个多一位，需要考虑进位的情况
// 时间复杂度O(max(m,n))
// 空间复杂度O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode falseRoot = new ListNode(0);
        ListNode pre = falseRoot;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode cur = new ListNode(sum % 10);
            pre.next = cur;
            pre = cur;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            ListNode cur = new ListNode(sum % 10);
            pre.next = cur;
            pre = cur;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            ListNode cur = new ListNode(sum % 10);
            pre.next = cur;
            pre = cur;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l2 = l2.next;
        }
        if (carry == 1) {
            ListNode cur = new ListNode(1);
            pre.next = cur;
        }
        return falseRoot.next;
    }
}