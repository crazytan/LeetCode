import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            if ((left == null) && (right == null)) return val + "";
            if (left == null) return "(" + val + ", ," + right + ")";
            if (right == null) return "(" + val + "," + left + ", )";
            return "(" + val + "," + left + "," + right + ")";
        }
    }

    private List<TreeNode> _generate(int min, int max, List<TreeNode>[][] arr) {
        if (min >= max) {
            if (arr[min][min] != null) return arr[min][min];
            TreeNode root = new TreeNode(min);
            arr[min][min] = new ArrayList<>();
            arr[min][min].add(root);
            return arr[min][min];
        }
        if (arr[min][max] != null) return arr[min][max];
        List<TreeNode> tmp, ans;
        ans = new ArrayList<>();
        tmp = _generate(min, max - 1, arr);
        for (TreeNode root: tmp) {
            TreeNode _root = new TreeNode(max);
            _root.left = root;
            _root.right = null;
            ans.add(_root);
        }
        tmp = _generate(min + 1, max, arr);
        for (TreeNode root: tmp) {
            TreeNode _root = new TreeNode(min);
            _root.left = null;
            _root.right = root;
            ans.add(_root);
        }
        for (int val = min + 1;val < max;val++) {
            List<TreeNode> leftList = _generate(min, val - 1, arr);
            List<TreeNode> rightList = _generate(val + 1, max, arr);
            for (TreeNode leftRoot: leftList)
                for (TreeNode rightRoot: rightList) {
                    TreeNode root = new TreeNode(val);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    ans.add(root);
                }
        }
        arr[min][max] = ans;
        return ans;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        if (n == 1) {
            TreeNode root = new TreeNode(1);
            List<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }
        List<TreeNode>[][] tmp = new List[n+1][];
        for (int i = 1;i <= n;i++) tmp[i] = new List[n+1];
        return _generate(1, n, tmp);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(2));
    }
}
