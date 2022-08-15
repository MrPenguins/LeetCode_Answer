// 算法简单但数学推导十分巧妙
// 设快慢指针走过的步数分别为f，s
// head到环入口的长度为a，环的长度为b
// 快慢指针第一次相遇时，可得等式：f=2s, f=s+nb
// 解得: s=nb, f=2nb
// 慢指针从head走到环入口，走过的距离为a+nb
// 因此只要慢指针再走a步，指向的节点就是环的入口
// 我们可以让快指针指向head，快慢指针每次各走一步
// 当它们相遇时，指向的节点就是环的入口
// 时间复杂度O(n)
// 空间复杂度O(1)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}