package algorithm;

/**
 * 面试题22：链表中倒数第k个节点
 * 题目：输入一个链表，输出该链表中的倒数第k个节点。
 */
public class _22_1_KthNodeFromEnd {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：定义两个指针：第一个先走k-1步，然后两个指针一起走，
     * 直到第一个到达尾节点，第二指针指的就是倒数第k个节点
     * 注意：k<=0 ; head为空节点； k>0且k>链表长度
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0 || head == null) return null;
        ListNode one = head;
        ListNode two = head;
        int i = 0;
        while (i < k - 1) {
            if (one.next == null) return null;
            one = one.next;
            i++;
        }
        while (one.next != null) {
            one = one.next;
            two = two.next;
        }
        return two;
    }
    //测试用例
    //https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1

}
