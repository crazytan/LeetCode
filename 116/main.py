# Definition for binary tree with next pointer.
class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class Solution(object):
    def _connect(self, root, curr, record):
        if root is curr:
            curr.next = None
        else:
            curr.next = self.find(root, list(record))
        if curr.left:
            self._connect(root, curr.left, record + [0])
        if curr.right:
            self._connect(root, curr.right, record + [1])

    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if not root:
            return root
        self._connect(root, root, [])

    def find(self, root, record):
        carry = 0
        for i in xrange(len(record)-1, -1, -1):
            if not record[i]:
                record[i] = 1
                carry = 0
                break
            record[i] = 0
            carry = 1
        if carry:
            return None
        tmp = root
        for i in record:
            if i:
                tmp = tmp.right
            else:
                tmp = tmp.left
        return tmp


if __name__ == "__main__":
    a = TreeLinkNode(1)
    b = TreeLinkNode(2)
    c = TreeLinkNode(3)
    d = TreeLinkNode(4)
    e = TreeLinkNode(5)
    f = TreeLinkNode(6)
    g = TreeLinkNode(7)
    a.left = b
    a.right = c
    b.left = d
    b.right = e
    c.left = f
    c.right = g
    Solution().connect(a)
    print 123