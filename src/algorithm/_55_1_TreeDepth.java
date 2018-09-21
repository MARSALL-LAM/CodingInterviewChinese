package algorithm;

/**
 * Author: Marsall
 * Date: Create in 10:11 2018/9/21
 * 面试题55：二叉树的深度
 * 题目一：输入一个二叉树的根节点，求该数的深度
 */

public class _55_1_TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int TreeDepth(TreeNode pRoot) {
        if (pRoot == null) return 0;
        int l = TreeDepth(pRoot.left);
        int r = TreeDepth(pRoot.right);
        return (l > r) ? (l + 1) : (r + 1);
    }
}
