package algorithm;

/**
 * 面试题28：对称的二叉树
 * 题目：判断一颗二叉树是不是对称的。如果一个棵二叉树和他的镜像一样，那么他是对称的。
 */
public class _28_1_SymmetricalBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot == null && pRoot1 == null) return true;
        if (pRoot == null || pRoot1 == null) return false;
        if (pRoot.val != pRoot1.val) return false;
        return isSymmetrical(pRoot.left, pRoot1.right) &&
                isSymmetrical(pRoot.right, pRoot1.left);
    }
    //测试用例
    //https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=3
}
