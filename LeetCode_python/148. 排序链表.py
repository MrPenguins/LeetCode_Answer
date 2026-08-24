# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def merge(self, head1, head2):
        cur1 = head1
        cur2 = head2
        dummy = ListNode(0)
        temp = dummy
        while cur1 and cur2:
            if cur1.val < cur2.val:
                temp.next = cur1
                cur1 = cur1.next
            else:
                temp.next = cur2
                cur2 = cur2.next
            temp = temp.next
        if cur2:
            cur1 = cur2
        while cur1:
            temp.next = cur1
            cur1 = cur1.next
            temp = temp.next
        return dummy.next, temp

    def next_k(self, head, k):
        if not head:
            return None
        cur = head
        for _ in range(k - 1):
            if cur.next:
                cur = cur.next
            else:
                break
        next_head = cur.next
        cur.next = None
        return next_head

    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        n = 0
        cur = head
        while cur:
            n += 1
            cur = cur.next
        step = 1
        dummy = ListNode(0, head)
        while step < n:
            prev = dummy
            cur = prev.next
            while cur:
                left = cur
                right = self.next_k(left, step)
                cur = self.next_k(right, step)
                prev.next, temp = self.merge(left, right)
                prev = temp
            step *= 2
        return dummy.next


if __name__ == "__main__":
    # 测试用例
    head = ListNode(4, ListNode(2, ListNode(1, ListNode(3))))
    solution = Solution()
    sorted_head = solution.sortList(head)

    # 输出排序后的链表
    cur = sorted_head
    while cur:
        print(cur.val, end=" -> ")
        cur = cur.next
    print("None")
