package algorithm;

import java.util.ArrayList;

/**
 * 面试题30：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能得到栈的最小元素的min函数。
 * 在该栈中，调用min、push、以及pop的时间复杂度都是O（1）
 */

/**
 * 分析：每次加入一个数后，用一个辅助数据结构记录此时栈的最小值
 *       每次pop栈顶，也把辅助数据结构的栈顶删除
 */
public class _30_1_MinInStack {

    private ArrayList<Integer> dataList = new ArrayList<>();
    private ArrayList<Integer> minList = new ArrayList<>();
    private Integer min = Integer.MAX_VALUE;

    public void push(int node) {
        dataList.add(node);
        if (node <= min) {
            minList.add(node);
            min = node;
        } else {
            minList.add(min);
        }
    }

    public int getSize() {
        return dataList.size();
    }

    public void pop() {
        int end = getSize() - 1;
        dataList.remove(end);
        minList.remove(end);
        min = minList.get(getSize() - 1);
    }

    public int top() {
        return dataList.get(getSize() - 1);
    }

    public int min() {
        return min;
    }
}
