package algorithm;

/**
 * 面试题24：反转链表
 * 题目：输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 */
public class _24_1_ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode ReversedHead = null;
        ListNode Node = head;
        ListNode Pre = null;
        while (Node != null) {
            ListNode Next = Node.next;
            if (Next == null)
                ReversedHead = Node;
            Node.next = Pre;
            Pre = Node;
            Node = Next;
        }
        return ReversedHead;
    }
    //测试用例
    //https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
