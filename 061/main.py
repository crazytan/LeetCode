# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if (not head) or (not k):
            return head
        if not head.next:
            return head
        l = self.calc_len(head)
        k = l - (k % l)
        end = head
        while end.next:
            end = end.next
        end.next = head
        while k > 1:
            head = head.next
            k -= 1
        tmp = head.next
        head.next = None
        return tmp

    def calc_len(self, head):
        if not head:
            return 0
        cnt = 0
        while head:
            cnt += 1
            head = head.next
        return cnt

if __name__ == "__main__":
    a = ListNode(1)
    b = ListNode(2)
    c = ListNode(3)
    d = ListNode(4)
    a.next = b
    b.next = c
    c.next = d
    head = Solution().rotateRight(a, 2)
    while head:
        print head.val
        head = head.next
