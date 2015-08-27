__author__ = 'tan'

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        fake = ListNode(None)
        head = fake
        while l1 and l2:
            if l1.val <= l2.val:
                fake.next = l1
                l1 = l1.next
            else:
                fake.next = l2
                l2 = l2.next
            fake = fake.next
        if l1:
            fake.next = l1
        if l2:
            fake.next = l2
        return head.next

if __name__ == '__main__':
    a = ListNode(1)
    b = ListNode(2)
    c = ListNode(3)
    d = ListNode(4)
    e = ListNode(5)
    f = ListNode(6)
    a.next = c
    c.next = e
    b.next = d
    d.next = f
    head = Solution().mergeTwoLists(a, b)
    while head:
        print head.val
        head = head.next
