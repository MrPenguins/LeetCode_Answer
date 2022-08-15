// 利用集合判断是否遍历过同样的元素
// 时间复杂度O(n)
// 空间复杂度O(n)

import java.util.HashSet;

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
        ListNode cur = head;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (cur != null) {
            if (hashSet.contains(cur)) {
                return cur;
            }
            hashSet.add(cur);
            cur = cur.next;
        }
        return null;
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