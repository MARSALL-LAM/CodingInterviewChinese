package algorithm;

import static java.lang.Math.pow;

/**
 * 面试题14：剪绳子
 * 题目：一根长度为n的绳子，请把绳子简称m段（m、n都为整数，n>1且m>1），每段绳子的长度记为k[0],k[1],……k[m]。
 * 请问k[0]*k[1]*……*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18.
 */
public class _14_1_CuttingRope {
    /**
     * 动态规划
     * f(n) = max(f(i)*f(n-i)
     * 递归效率不高，所以直接从f（1）向上开始计算
     * 时间复杂度O(n*n)
     */
    public int DynamicProgramming(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] Max = new int[n + 1];
        Max[0] = 0;
        Max[1] = 1;
        Max[2] = 2;
        Max[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = Max[j] * Max[i - j];
                if (temp > max)
                    max = temp;
                Max[i] = max;
            }
        }
        max = Max[n];
        return max;
    }

    /**
     * 贪婪算法
     * 当n>5，尽可能多剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子
     * 时间复杂度为O(1)
     */
    public int Greedy(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        //尽可能多剪长度为3的绳子段
        int timesOf3 = n / 3;
        //当绳子剩下长度为4，剪为2*2
        if (n - timesOf3 * 3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (pow(3, timesOf3)) * (int) (pow(2, timesOf2));
    }

    /**
     * 测试用例
     * 1.功能测试（n>)
     * 2.边界值测试（0,1,2,3,4)
     */
    public static void main(String[] args) {
        _14_1_CuttingRope a = new _14_1_CuttingRope();
        System.out.println(a.DynamicProgramming(50));
        System.out.println(a.Greedy(50));
        System.out.println(a.DynamicProgramming(10));
        System.out.println(a.Greedy(10));
        System.out.println(a.DynamicProgramming(0) + " " + a.DynamicProgramming(1) + " " +
                a.DynamicProgramming(2) + " " + a.DynamicProgramming(3) + " " + a.DynamicProgramming(4) + " ");
        System.out.println(a.Greedy(0) + " " + a.Greedy(1) + " " +
                a.Greedy(2) + " " + a.Greedy(3) + " " + a.Greedy(4) + " ");

    }
}
