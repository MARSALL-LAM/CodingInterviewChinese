package algorithm;

/**
 * 面试题33：二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class _33_1_SequenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int root = sequence[end];
        int i = start;
        for (; i < end && sequence[i] < root; i++) {
        }
        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root)
                return false;
        }
        return VerifySquenceOfBST(sequence, start, i - 1) && VerifySquenceOfBST(sequence, i, end - 1);
    }
    //测试用例
    //https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
