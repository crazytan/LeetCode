# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if (not head) or (not head.next):
            return True
        l = 0
        tmp = head
        while tmp:
            l += 1
            tmp = tmp.next
        head_l = head
        cnt = 1
        while cnt < (l/2):
            cnt += 1
            head_l = head_l.next
        if l % 2:
            head_r = head_l.next.next
        else:
            head_r = head_l.next
        prev = None
        tmp = head
        while tmp != head_l:
            _tmp = tmp.next
            tmp.next = prev
            prev = tmp
            tmp = _tmp
        tmp.next = prev
        while head_l:
            if head_l.val != head_r.val:
                return False
            head_l = head_l.next
            head_r = head_r.next
        return True


if __name__ == "__main__":
    a = ListNode(1)
    b = ListNode(2)
    c = ListNode(2)
    d = ListNode(1)
    a.next = b
    b.next = d
    # c.next = d
    print Solution().isPalindrome(a)
