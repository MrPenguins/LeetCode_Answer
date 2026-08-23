# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast = slow = head
        flag = False
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if slow == fast:
                flag = True
                break
        if not flag:
            return None
        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow
