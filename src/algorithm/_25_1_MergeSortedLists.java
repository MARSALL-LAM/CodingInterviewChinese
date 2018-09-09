package algorithm;

/**
 * 面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并两个链表并使新链表中的节点仍然是递增排序的。
 */
public class _25_1_MergeSortedLists {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode MergedHead = null;
        if (list1.val < list2.val) {
            MergedHead = list1;
            MergedHead.next = Merge(list1.next, list2);
        } else {
            MergedHead = list2;
            MergedHead.next = Merge(list1, list2.next);
        }
        return MergedHead;
    }
    //测试用例
    //https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
