package algorithm;

/**
 * 面试题23：链表中环的入口节点
 */
public class _23_1_EntryNodeInListLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：1.先判断是否存在环：一个快指针走两步，一个慢指针走一步
     *      如果快指针走到表尾(null)则不存在环，若快指针追上慢指针则存在环
     *      2.找出环中起点，通过1.判断后两个指针指向环中的同一节点，
     *      然后其中一个节点从表头开始走起，同时另一个也走，最终两个节点相遇的节点即是环的起点
     *
     *      已知道有环的情况
     *      假设非环部分长度为a，环为b，那么假设slow走了k步，才与fast相遇
     *      那么(k-a)%b == (2k-a)%b
     *      当a<b时，相遇点到头节点的长度即为环的长度
     *      当a>b时，相遇点到头结点的长度-（a-a%b)即为环的长度
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = pHead;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                if(slow == fast)
                    return slow;
            }
        }
        return null;
    }
    //测试用例
    //https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=3
}
