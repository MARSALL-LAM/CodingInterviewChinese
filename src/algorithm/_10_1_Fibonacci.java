package algorithm;

/**
 * 面试题10：斐波那契数列
 * 题目一：求斐波那契数列的第n项
 * 题目二：青蛙跳台阶问题（实现相当于斐波那契数列）
 */
public class _10_1_Fibonacci {
    /**
     * 分析：
     * 递归算法在当n很大，效率特别差。因为调用次数呈2的倍数增长
     * 用循环代替递归
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n < 2) return n;
        int one = 0, two = 1, three = 0;
        while (n >= 2) {
            three = one + two;
            one = two;
            two = three;
            n--;
        }
        return three;
    }
//测试用例
    //https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
