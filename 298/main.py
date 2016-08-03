class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def _longestConsecutive(self, root, ans):
        if not root.left and not root.right:
            return 1
        ret = 1
        if root.left:
            ans_left = self._longestConsecutive(root.left, ans)
            if (root.val == root.left.val - 1) and ((ans_left + 1) > ret):
                ret = ans_left + 1
        if root.right:
            ans_right = self._longestConsecutive(root.right, ans)
            if (root.val == root.right.val - 1) and ((ans_right + 1) > ret):
                ret = ans_right + 1
        if ret > ans[0]:
            ans[0] = ret
        return ret

    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        ans = [1]
        self._longestConsecutive(root, ans)
        return ans[0]

if __name__ == "__main__":
    n1 = TreeNode(2)
    n2 = TreeNode(3)
    n3 = TreeNode(2)
    n4 = TreeNode(1)
    n5 = TreeNode(5)
    n1.right = n2
    n2.left = n3
    n2.left = n4
    print Solution().longestConsecutive(n1)
