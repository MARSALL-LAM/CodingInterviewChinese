package algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: Marsall
 * Date: Create in 17:10 2018/9/23
 * 面试题59：队列的最大值
 * 题目二：队列的最大值
 * 题目：定义一个队列并实现函数max得到队列的最大值，
 * 要求函数max、push_back和pop_front的时间复杂度都是O(1)
 */
public class _59_2_QueueWithMax<T extends Comparable<T>> {
    private int currentIndex = 0;

    class InternalData {
        T number;
        int index;

        public InternalData(T number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    private Deque<InternalData> data = new LinkedList<>();
    private Deque<InternalData> maximuns = new LinkedList<>();

    void push_back(T number) {
        while (!maximuns.isEmpty() && number.compareTo(maximuns.peekLast().number) >= 0)
            maximuns.pollLast();
        InternalData internalData = new InternalData(number, currentIndex);
        data.offerLast(internalData);
        maximuns.offerLast(internalData);
        currentIndex++;
    }

    void pop_front() throws Exception {
        if (maximuns.isEmpty())
            throw new Exception("Empty");
        if (maximuns.peek().index == data.peek().index)
            maximuns.poll();
        data.poll();
    }

    T max() throws Exception {
        if (maximuns.isEmpty())
            throw new Exception("Empty");
        return maximuns.peek().number;
    }
    public static void main(String[] args) throws Exception {
        _59_2_QueueWithMax<Integer> queue = new _59_2_QueueWithMax<Integer>();
        queue.push_back(6);
        System.out.println(queue.max());
        queue.push_back(6);
        System.out.println(queue.max());
        queue.push_back(6);
        System.out.println(queue.max());
        queue.push_back(6);
        System.out.println(queue.max());
        queue.pop_front();
        System.out.println(queue.max());

    }
}
