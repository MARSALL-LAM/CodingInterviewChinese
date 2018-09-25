package algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: Marsall
 * Date: Create in 16:56 2018/9/25
 * 面试题68：树中两个节点的最低公共祖先
 */
public class _68_1_CommonParentInTree {
    /**
     * 若是二叉搜索树：
     * 分析：根据二叉搜索树的特性，某个节点的值大于一个而小于另一个节点，这个节点就是他们的最低公共祖先
     */

    /**
     * 若不是二叉树，而是普通的数，并且有指向父亲的指针，则变成了两个链表的第一个公共节点
     * 参考_52_1_FirstCommonNodesInLists
     */

    /**
     * 既是普通树，也无指向父亲的指针
     * 分析：将题目转换成在两条路径里找到最后一个公共节点
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode getLastCommonParent(TreeNode root, TreeNode one, TreeNode two) {
        Deque<TreeNode> list1 = new LinkedList<>();
        Deque<TreeNode> list2 = new LinkedList<>();
        getNodePath(root, one, list1);
        getNodePath(root, two, list2);
        return getLastCommonNode(list1, list2);
    }

    private static TreeNode getLastCommonNode(Deque<TreeNode> list1, Deque<TreeNode> list2) {
        TreeNode temp = null;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.peek() != list2.peek())
                return temp;
            temp = list1.poll();
            list2.poll();
        }
        return temp;
    }

    private static boolean getNodePath(TreeNode root, TreeNode node, Deque<TreeNode> list) {
        if (root == node) return true;
        list.offer(root);
        boolean found = false;
        if (root.left != null)
            found = getNodePath(root.left, node, list);
        if (root.right != null && found == false)
            found = getNodePath(root.right, node, list);
        if (found == false)
            list.pollLast();
        return found;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        System.out.println(getLastCommonParent(A, F, B).val);
    }
}
