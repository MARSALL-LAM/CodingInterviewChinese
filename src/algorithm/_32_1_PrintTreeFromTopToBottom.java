package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 面试题32：从上到下打印二叉树
 * 题目1：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 题目2：分行从上到下打印二叉树，每一层打印一行。
 * 题目3：之字形打印二叉树:请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _32_1_PrintTreeFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //题目1
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        queue.offer(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            arrayList.add(temp.val);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        return arrayList;
    }
    //测试用例
    //https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

    //题目2
    public ArrayList<ArrayList<Integer>> PrintTreesInLines(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (pRoot == null) return arrayList;
        queue.offer(pRoot);
        int nextLevel = 0;
        int toBePrinted = 1;
        TreeNode temp = null;
        ArrayList<Integer> subArrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            temp = queue.poll();
            subArrayList.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
                nextLevel++;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0) {
                arrayList.add(subArrayList);
                subArrayList = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return arrayList;
    }
    //测试用例
    //https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

    //题目3
    public ArrayList<ArrayList<Integer>> PrintTreesInZigzag(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return arrayList;
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        odd.push(pRoot);
        ArrayList<Integer> subArrayList = new ArrayList<>();
        int current = 1;
        int toBePrint = 1;
        int next = 0;
        TreeNode temp = null;
        while (!odd.isEmpty() || !even.isEmpty()) {
            if (current == 1) {
                temp = odd.pop();
                toBePrint--;
                subArrayList.add(temp.val);
                if (temp.left != null) {
                    even.push(temp.left);
                    next++;
                }
                if (temp.right != null) {
                    even.push(temp.right);
                    next++;
                }
            } else {
                temp = even.pop();
                toBePrint--;
                subArrayList.add(temp.val);
                if (temp.right != null) {
                    odd.push(temp.right);
                    next++;
                }
                if (temp.left != null) {
                    odd.push(temp.left);
                    next++;
                }
            }
            if (toBePrint == 0) {
                arrayList.add(subArrayList);
                subArrayList = new ArrayList<>();
                current = 1 - current;
                toBePrint = next;
                next = 0;
            }
        }
        return arrayList;
    }
    //测试用例
    //https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
}
