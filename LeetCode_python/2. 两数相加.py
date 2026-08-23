# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        prev_head = ListNode(0)
        sum = prev_head
        flag = False
        while l1 and l2:
            if flag:
                sum.next = ListNode(1)
            else:
                sum.next = ListNode(0)
            sum = sum.next
            sum.val += l1.val + l2.val
            if sum.val > 9:
                sum.val -= 10
                flag = True
            else:
                flag = False
            l1 = l1.next
            l2 = l2.next
        if l2:
            l1 = l2
        while l1:
            if flag:
                sum.next = ListNode(1)
            else:
                sum.next = ListNode(0)
            sum = sum.next
            sum.val += l1.val
            if sum.val > 9:
                sum.val -= 10
                flag = True
            else:
                flag = False
                sum.next = l1.next
                break
            l1 = l1.next
        if flag:
            sum.next = ListNode(1)
        return prev_head.next


# 更优雅的写法
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        prev_head = ListNode(0)
        cur = prev_head
        carry = 0
        while l1 or l2 or carry:
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            sum = x + y + carry
            carry = sum // 10
            cur.next = ListNode(sum % 10)
            cur = cur.next
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        return prev_head.next
