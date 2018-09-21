package algorithm;

/**
 * Author: Marsall
 * Date: Create in 10:11 2018/9/21
 * 面试题55：二叉树的深度
 * 题目二：平衡二叉树
 * 题目：输入一个根节点，判断是不是平衡二叉树
 */
public class _55_2_BalancedBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断子树是否平衡时，若不平衡无需再遍历其他节点
     * @param pRoot
     * @return
     */
    boolean isBalanced(TreeNode pRoot) {
        return isBalancedCore(pRoot) != -1;
    }

    private int isBalancedCore(TreeNode pRoot) {
        if (pRoot == null) return 0;
        int left = isBalancedCore(pRoot.left);
        if (left == -1) return -1;
        int right = isBalancedCore(pRoot.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
    //测试用例
    //https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
