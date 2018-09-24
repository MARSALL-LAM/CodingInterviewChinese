package algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: Marsall
 * Date: Create in 15:29 2018/9/21
 * 面试题59：队列的最大值
 * 题目一：滑动窗口的最大值
 * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小为3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}
 */
public class _59_1_MaxInSlidingWindow {
    static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num.length <= 0 || num.length < size || size < 1) return null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        //先找第一个窗口的最大值
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        //添加最大值是从第一个窗口开始，每次添加下一个窗口的最大值，所以循环结束后还要添加一次最大值
        for (int i = size; i < num.length; i++) {
            arrayList.add(num[deque.peek()]);
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()])
                deque.pollLast();
            if (!deque.isEmpty() && deque.peek() <= (i - size))
                deque.poll();
            deque.offerLast(i);
        }
        arrayList.add(num[deque.peek()]);
        for (int a : arrayList
        ) {
            System.out.println(a);
        }
        return arrayList;
    }

    /**
     * 测试用例：
     * 1.功能测试
     * 2.边界测试
     * 3.特殊测试
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        maxInWindows(a, 9);
    }
}
