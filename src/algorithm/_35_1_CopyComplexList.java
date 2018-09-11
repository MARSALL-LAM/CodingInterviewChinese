package algorithm;

/**
 * 面试题35：复杂链表的复制
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class _35_1_CopyComplexList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 分析：O(n)的做法：1.将每个节点复制到其后
     * 2.根据原节点任意指针，设置复制后节点的任意指针
     * 3.拆分原和复制链表
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        CopyOriginalNode(pHead);
        CopyRandomNode(pHead);
        return DivideListNode(pHead);
    }

    private RandomListNode DivideListNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if (pNode != null) {
            pClonedHead = pNode.next;
            pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }

    private void CopyRandomNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pCloned = null;
        while (pNode != null) {
            pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }

    private void CopyOriginalNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }
    //测试用例
    //https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
