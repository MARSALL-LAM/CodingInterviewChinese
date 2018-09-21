package algorithm;

/**
 * Author: Marsall
 * Date: Create in 9:52 2018/9/21
 * 面试题54：二叉搜索树的第K小节点
 */
public class _54_1_KthNodeInBST {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：根据二叉树的特性，我们将他中序遍历，第k个节点就是k小的节点
     * 平均时间复杂度：O(n)
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;
        return KthNodeCore(pRoot, k);
    }

    private TreeNode KthNodeCore(TreeNode pRoot, int k) {
        TreeNode target = null;
        if (pRoot.left != null)
            target = KthNodeCore(pRoot.left, k);
        if (target == null) {
            if (k == 1)
                target = pRoot;
            k--;
        }
        if (pRoot.right != null)
            target = KthNode(pRoot.right, k);
        return target;
    }
}
