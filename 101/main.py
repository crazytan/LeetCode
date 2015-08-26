__author__ = 'tan'

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        return self.isSymmetric_(root.left, root.right)

    def isSymmetric_(self, left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        if left.val != right.val:
            return False
        return self.isSymmetric_(left.left, right.right) and self.isSymmetric_(left.right, right.left)

if __name__ == '__main__':
    a = TreeNode(1)
    b = TreeNode(2)
    c = TreeNode(2)
    d = TreeNode(3)
    e = TreeNode(3)
    f = TreeNode(4)
    g = TreeNode(4)
    a.left = b
    a.right = c
    b.left = d
    b.right = f
    c.left = g
    c.right = e
    print Solution().isSymmetric(a)
