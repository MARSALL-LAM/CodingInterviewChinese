package algorithm;

import java.util.Stack;

/**
 * 面试题31：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class _31_1_StackPushPopOrder {
    /**
     * 分析：遍历弹出序列：当遍历到下标为i时，遍历压入序列，并压入辅助栈中，直到找到popA[i]
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        if (pushA.length != popA.length) return false;
        int j = 0;
        for (int i = 0; i < popA.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popA[i]) stack.pop();
            else {
                while (j < pushA.length && popA[i] != pushA[j])
                    stack.push(pushA[j++]);
                if (j == pushA.length ) return false;
                j++;
            }
        }
        return true;
    }
    //测试用例
    //https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=2
}
