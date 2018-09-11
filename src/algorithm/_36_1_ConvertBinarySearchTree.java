package algorithm;

import java.util.Stack;

/**
 * 面试题36：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _36_1_ConvertBinarySearchTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：若节点无左孩子，该节点为最小节点
     * 若节点有左孩子，该节点左指针指向左孩子最小
     * 若节点有右孩子，则该节点的右指针指向右孩子的最左，右孩子的最左节点的右指针指向该节点
     * 若节点无右孩子，则该节点的右指针指向节点的父亲，父亲的左指针指向该节点
     *
     * @param pRootOfTree
     * @return
     */
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        //return solution(pRootOfTree);
        solution2(pRootOfTree);
        return realHead;
    }

    /**
     * 递归版 :无脑中序遍历
     *
     * @param pRootOfTree
     * @return
     */


    private void solution2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        solution2(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        solution2(pRootOfTree.right);
    }

    /**
     * 非递归版：1.先找到最小节点
     * 2.从最小节点开始，保存当前节点，寻找下一个节点（其右节点）
     * 若有右子树，找到右子树最小节点
     * 没有右子树，往上走；若其为其父亲右节点，一直走直到找到为其父亲左节点的节点
     *
     * @param pRootOfTree
     * @return
     */
    private TreeNode solution(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        //作为引用上一个节点
        TreeNode pre = null;
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isFirst) {
                pRootOfTree = p;
                pre = p;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }
    //测试用例
    //https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
}
