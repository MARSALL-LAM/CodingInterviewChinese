package algorithm;

/**
 * 面试题18：删除链表的节点
 * 题目一：在O(1)时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1）时间内删除该节点
 * 题目二：删除链表中重复的节点
 * 在一个排序的链表中，如何删除重复的节点
 */
public class _18_1_DeleteNodeInList {
    public static class ListNode{
        int value;
        ListNode next;
    }
    /**
     * 题目一
     * 分析：1.避免查找该节点的前驱节点，将下一个节点内容覆盖给该节点，删除下一个节点
     *       2.若为尾节点，则必须从头节点开始找到其前驱节点
     *       3.若只有一个节点，则置null
     * 对于(n-1)个非尾节点，删除的时间为O(1);尾节点的时间为O(n)
     * 平均时间复杂度为[(n-1)*O(1)+O(n）]/n = O(1)
     */
    public static void solution1(ListNode head,ListNode delete){
        if (head == null || delete == null)return;;
        //要删除的节点不是尾节点
        if (delete.next != null){
            ListNode next = delete.next;
            delete.value = next.value;
            delete.next = next.next;
            next.next = null;
            next = null;
        }
        //链表只有一个节点
        else if (head == delete){
            head = null;
            delete = null;
        }
        //尾节点
        else {
            ListNode pHead = head;
            while (pHead.next != delete)
                pHead = pHead.next;
            pHead.next = null;
            delete = null;
        }
    }
}
