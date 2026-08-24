# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# 采用分治法，时间复杂度为 O(NlogK)，空间复杂度为 O(1)
class Solution:
    def merge(self, head1, head2):
        cur1 = head1
        cur2 = head2
        dummy = ListNode(0)
        cur = dummy
        while cur1 and cur2:
            if cur1.val < cur2.val:
                cur.next = cur1
                cur1 = cur1.next
            else:
                cur.next = cur2
                cur2 = cur2.next
            cur = cur.next
        cur.next = cur1 if cur1 else cur2
        return dummy.next

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        k = len(lists)
        step = 1
        while step < k:
            cur = 0
            while cur + step < k:
                lists[cur] = self.merge(lists[cur], lists[cur + step])
                cur += 2 * step
            step *= 2
        return lists[0]


# 采用优先队列，时间复杂度为 O(NlogK)，空间复杂度为 O(K)
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        heap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(heap, (node.val, i, node))
        dummy = ListNode(0)
        cur = dummy
        count = len(lists)
        while heap:
            _, i, node = heapq.heappop(heap)
            cur.next = node
            cur = cur.next
            if node.next:
                heapq.heappush(heap, (node.next.val, count, node.next))
                count += 1
        return dummy.next
