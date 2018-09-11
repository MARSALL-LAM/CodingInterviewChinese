package algorithm;

import java.util.ArrayList;

/**
 * 面试题34：二叉树中和为某一值的路径
 * 题目：输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class _34_1_PathInTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> subArratList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return arrayLists;
        subArratList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            arrayLists.add(new ArrayList<>(subArratList));
        FindPath(root.left, target);
        FindPath(root.right, target);
        subArratList.remove(subArratList.size() - 1);
        return arrayLists;
    }
    //测试用例
    //https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
}
