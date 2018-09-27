package algorithm;

/**
 * 面试题15：二进制中1的个数
 * 题目：输入一个整数，输出该数二进制表示1的个数。
 * 分析：一般思路，右移并记录。但是当该数为负数时，右移会保持最高位为1，致使程序进入无限循环。
 */

public class _15_1_NumberOf1InBinary {
    public int NumberOf1(int n) {
        //return solution1(n);
        return solution2(n);
    }

    /**
     * 分析从左到右遇到某个为1，就将该为变0，并计数。这种方法只用循环1的个数次数。
     * n-1会使从右到左遇到的第一个1变0，并且该为右边的所有位置1。所以n&(n-1)会使n从右边到左第一个1的为置0
     *
     * @param n
     * @return
     */
    private int solution2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }

    //用左移参照数的方法：r = 1与n做&操作，结果为一，则count++。总共循环32次
    private int solution1(int n) {
        int count = 0, r = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & r) != 0)
                count++;
            r <<= 1;

        }
        return count;
    }
    //测试用例
    //https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
