__author__ = 'tan'


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        l = []
        tmp = head
        while tmp:
            l.append(tmp)
            tmp = tmp.next
        if n == len(l):
            return head.next
        l[-(n+1)].next = l[-n].next
        return head

if __name__ == '__main__':
    a = ListNode(1)
    b = ListNode(2)
    c = ListNode(3)
    d = ListNode(4)
    a.next = b
    # b.next = c
    # c.next = d
    head = Solution().removeNthFromEnd(a, 1)
    while head:
        print head.val
        head = head.next
