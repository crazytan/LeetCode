# Definition for binary tree with next pointer.
class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if not root:
            return root
        root.next = None
        _head = _curr = TreeLinkNode(0)
        curr = root
        while curr:
            while curr:
                if curr.left:
                    _curr.next = curr.left
                    _curr = _curr.next
                if curr.right:
                    _curr.next = curr.right
                    _curr = _curr.next
                curr = curr.next
            curr = _head.next
            _head.next = None
            _curr = _head

        # depth = 1
        # while True:
        #     if not self.assign_next(root, depth):
        #         break
        #     depth += 1
        # self._connect(root, root, 0, 0)

    # def assign_next(self, root, depth):
    #     cnt, curr = self.find_next(root, depth, 0)
    #     if not curr:
    #         return False
    #     while curr:
    #         cnt, _next = self.find_next(root, depth, cnt + 1)
    #         curr.next = _next
    #         if not _next:
    #             break
    #         curr = _next
    #     return True

    # def _connect(self, root, curr, depth, record):
    #     if root is curr:
    #         curr.next = None
    #     else:
    #         curr.next = self.find(root, depth, record)
    #     if curr.left:
    #         self._connect(root, curr.left, depth + 1, record << 1)
    #     if curr.right:
    #         self._connect(root, curr.right, depth + 1, (record << 1) + 1)

    # def find_next(self, root, depth, record):
    #     while record < (1 << depth):
    #         result = self.locate(root, depth, record)
    #         if result:
    #             return record, result
    #         record += 1
    #     return 0, None
    #
    # def locate(self, root, depth, cnt):
    #     tmp = root
    #     for i in xrange(depth - 1, -1, -1):
    #         if cnt & (1 << i):
    #             tmp = tmp.right
    #         else:
    #             tmp = tmp.left
    #         if not tmp:
    #             return None
    #     return tmp

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