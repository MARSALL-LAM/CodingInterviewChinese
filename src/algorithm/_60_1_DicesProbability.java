package algorithm;

/**
 * Author: Marsall
 * Date: Create in 17:42 2018/9/23
 * 面试题60：n个骰子的点数
 * 题目：把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值得出现的概率
 */
public class _60_1_DicesProbability {
    /**
     * 分析：当只有一个骰子的时候，和为1--6的次数都是1次；
     * 当有两个骰子以上的时候，和为n的次数为上一轮骰子和为n-1、n-2、n-3、n-4、n-5、n-6的次数总和
     */
    static final int VALUE = 6;

    static void PrintProbability(int number) {
        if (number < 1) return;

        int[][] pPropbability = new int[2][VALUE * number + 1];
        int flag = 0;
        for (int i = 1; i <= VALUE; i++) {
            pPropbability[flag][i] = 1;
        }
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {
                pPropbability[1 - flag][i] = 0;
            }
            for (int i = k; i <= VALUE * k; i++) {
                pPropbability[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= VALUE; j++)
                    pPropbability[1 - flag][i] += pPropbability[flag][i - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow((double) VALUE, number);
        for (int i = number; i <= VALUE * number; i++) {
            double ratio = (double) pPropbability[flag][i] / total;
            System.out.println(i + " " + ratio);
        }
    }

    public static void main(String[] args) {
        _60_1_DicesProbability.PrintProbability(2);
    }
}
