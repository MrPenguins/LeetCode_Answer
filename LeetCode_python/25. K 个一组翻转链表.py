from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverse(self, head, k):
        cur = head
        prev = None
        for _ in range(k):
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        return prev, head

    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        sub_head = dummy
        cur = dummy.next
        cnt = 1
        while cur:
            if cnt == k:
                cur = cur.next
                cnt = 1
                new_head, new_tail = self.reverse(sub_head.next, k)
                sub_head.next = new_head
                new_tail.next = cur
                sub_head = new_tail
            else:
                cur = cur.next
                cnt += 1
        return dummy.next


if __name__ == "__main__":
    # 测试用例
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    k = 2
    solution = Solution()
    new_head = solution.reverseKGroup(head, k)
    while new_head:
        print(new_head.val, end=" -> ")
        new_head = new_head.next
    print("None")
