package algorithm;

/**
 * Author: Marsall
 * Date: Create in 13:55 2018/9/21
 * 面试题57：和为s的数
 * 题目二：和为s的连续正数序列
 * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）
 */
public class _57_2_ContinuousSequenceWithSum {
    /**
     * 分析：要点：连续；大于等于两个数
     * 所以界为（1+length）/2
     */
    static void FindContinuousSequence(int sum) {
        if (sum < 3) return;
        ;
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum)
                PrintContinuousSequence(small, big);
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum)
                    PrintContinuousSequence(small, big);
            }
            big++;
            curSum += big;
        }
    }

    private static void PrintContinuousSequence(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        FindContinuousSequence(15);
    }
}
