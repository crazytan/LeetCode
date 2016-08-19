import java.util.*;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<TreeNode> nodeQueue = new ArrayList<>();
        nodeQueue.add(root);
        List<Integer> columnQueue = new ArrayList<>();
        columnQueue.add(0);
        int i = 0;
        while (i < nodeQueue.size()) {
            TreeNode currNode = nodeQueue.get(i);
            int currColumn = columnQueue.get(i);
            if (currNode.left != null) {
                nodeQueue.add(currNode.left);
                columnQueue.add(currColumn - 1);
            }
            if (currNode.right != null) {
                nodeQueue.add(currNode.right);
                columnQueue.add(currColumn + 1);
            }
            i++;
        }
        int min = 0, max = 0;
        for (i = 0; i < columnQueue.size(); i++) {
            if (columnQueue.get(i) < min) min = columnQueue.get(i);
            if (columnQueue.get(i) > max) max = columnQueue.get(i);
        }
        max -= min;
        for (i = 0; i <= max; i++) ans.add(new ArrayList<>());
        for (i = 0; i < nodeQueue.size(); i++) {
            int index = columnQueue.get(i) - min;
            ans.get(index).add(nodeQueue.get(i).val);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(new Solution().verticalOrder(n1));
    }
}
