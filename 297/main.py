# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""
        return str(root.val) + '(' + self.serialize(root.left) + ')(' + self.serialize(root.right) + ')'

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        start = data.find('(')
        end = start+1
        root = TreeNode(int(data[:start]))
        cnt = 1
        for end in range(start+1, len(data)):
            if data[end] == '(':
                cnt += 1
            elif data[end] == ')':
                cnt -= 1
            if not cnt:
                break
        left_data = data[start+1:end]
        right_data = data[end+2:len(data)-1]
        root.left = self.deserialize(left_data)
        root.right = self.deserialize(right_data)
        return root


# Your Codec object will be instantiated and called as such:
if __name__ == "__main__":
    a = TreeNode(1)
    b = TreeNode(2)
    c = TreeNode(3)
    d = TreeNode(4)
    e = TreeNode(5)
    a.left = b
    a.right = c
    c.left = d
    c.right = e
    codec = Codec()
    print codec.serialize(a)
    print codec.serialize(codec.deserialize(codec.serialize(a)))
