"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        cur = head
        while cur:
            cur.next = Node(cur.val, cur.next)
            cur = cur.next.next
        cur = head
        while cur:
            cur.next.random = cur.random.next if cur.random else None
            cur = cur.next.next
        cur = head
        cur_copy = cur.next
        dummy = Node(0, cur.next)
        while cur:
            cur_copy = cur.next
            cur.next = cur_copy.next
            cur = cur.next
            if cur_copy.next:
                cur_copy.next = cur_copy.next.next
        return dummy.next
