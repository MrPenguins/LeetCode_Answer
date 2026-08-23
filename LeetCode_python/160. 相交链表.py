# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        length_a = 0
        length_b = 0
        cur = headA
        while cur is not None:
            length_a += 1
            cur = cur.next
        cur = headB
        while cur is not None:
            length_b += 1
            cur = cur.next
        a = headA
        b = headB
        if length_a > length_b:
            a, b = b, a
            length_a, length_b = length_b, length_a
        for _ in range(length_b - length_a):
            b = b.next
        while a != b:
            a = a.next
            b = b.next
        return a


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        a, b = headA, headB
        while a != b:
            a = a.next if a else headB
            b = b.next if b else headA
        return a
