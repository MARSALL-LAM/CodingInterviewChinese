package algorithm;

import java.util.Stack;

/**
 * 面试题09：用两个栈实现队列
 * 题目
 */
public class _09_1_QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int pop;

    /**
     * 栈为后进先出，而队列为先进先出
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        pop = stack2.pop();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return pop;
    }
    //测试用例
    //https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
