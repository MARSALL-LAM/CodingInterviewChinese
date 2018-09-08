package algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 面试题06：从尾到头打印链表
 * 题目：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 */
public class _06_1_PrintListInReversedOrder {
     class ListNode {
        int val;
        ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：后进先出符合栈的特性；链表不大时可用递归实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> solution(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        ListNode pNode = listNode;
        while (pNode != null){
            stack.push(pNode);
            pNode = pNode.next;
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }
}
