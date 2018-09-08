package algorithm;

/**
 * 面试题07：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 */
public class _07_1_ConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 分析：前序序列第一个元素一定是根节点，中序序列根节点左边的序列为左孩子，右边为右孩子
     * 自上向下建树
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length <= 0 || in.length <= 0) return null;
        return solution(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode solution(int[] pre, int pS, int pE, int[] in, int iS, int iE) {
        if (pS > pE || iS > iE) return null;
        TreeNode node = new TreeNode(pre[pS]);
        int leftLength = 0;
        while (leftLength <= iE - iS && pre[pS] != in[iS + leftLength])
            leftLength++;
        node.left = solution(pre, pS + 1, pS + leftLength, in, iS, leftLength + iS - 1);
        node.right = solution(pre, pS + leftLength + 1, pE, in, iS + leftLength + 1, iE);
        return node;
    }
    //测试用例
    //https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
