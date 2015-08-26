__author__ = 'tan'

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        return self.levelOrder(root)[::-1]

    def levelOrder(self, root):
        if not root:
            return []
        if not root.left and not root.right:
            return [[root.val]]
        ans = [[root.val]]
        lIter = iter(self.levelOrder(root.left))
        rIter = iter(self.levelOrder(root.right))
        while True:
            lNext = next(lIter, None)
            rNext = next(rIter, None)
            if not lNext and not rNext:
                break
            lNext = [] if not lNext else lNext
            rNext = [] if not rNext else rNext
            ans.append(lNext + rNext)
        return ans

if __name__ == '__main__':
    a = TreeNode(1)
    b = TreeNode(2)
    c = TreeNode(3)
    d = TreeNode(4)
    e = TreeNode(5)
    c.left = d
    c.right = e
    a.left = b
    a.right = c
    print Solution().levelOrderBottom(d)