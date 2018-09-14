package algorithm;

import java.util.Stack;

/**
 * 面试题52：两个链表的第一个公共节点
 * 题目：输入两个链表，找出它们的第一个公共结点。
 */
public class _52_1_FirstCommonNodesInLists {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        ListNode common = null;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            stack1.pop();
            common = stack2.pop();
        }
        return common;
    }
    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(7);
        p1.next = p2;
        p2.next = p3;
        p4.next = p5;
        p6.next = p7;
        p3.next = p6;
        p5.next = p6;
        System.out.println(FindFirstCommonNode(p1,p4).val);

    }
}
