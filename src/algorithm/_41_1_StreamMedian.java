package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class _41_1_StreamMedian {
    /**
     * 分析：大数放最小堆中，小数放最大堆中
     *      总数为偶则为，两堆顶和一半；为奇，则为最小堆顶
     */
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int mark = 0;

    public void Insert(Integer num) {
        if (mark == 0) {
            max.offer(num);
            min.offer(max.poll());
            mark = 1 - mark;
        } else {
            min.offer(num);
            max.offer(min.poll());
            mark = 1 - mark;
        }
    }

    public Double GetMedian() {
        if (mark == 1){
            return new Double(min.peek());
        }
        else
            return new Double(min.peek()+max.peek())/2;
    }
    //测试用例
    //https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
