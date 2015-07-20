__author__ = 'tan'

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        head = ListNode(0)
        now = head
        tmp = 0
        while (l1 is not None) | (l2 is not None):
            tmp += l1.val if l1 is not None else 0
            tmp += l2.val if l2 is not None else 0
            now.next = ListNode(tmp % 10)
            now = now.next
            tmp /= 10
            l1 = l1.next if l1 is not None else None
            l2 = l2.next if l2 is not None else None
        if tmp > 0:
            now.next = ListNode(tmp)
        return head.next
