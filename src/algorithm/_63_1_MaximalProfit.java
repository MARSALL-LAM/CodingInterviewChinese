package algorithm;

/**
 * Author: Marsall
 * Date: Create in 13:36 2018/9/25
 * 面试题63：股票的最大利润
 * 题目：假设某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候买入
 * 并在价格16时卖出，则能收获最大的利润11.
 */
public class _63_1_MaximalProfit {
    static int MaxDiff(int[] numbers) {
        if (numbers.length < 2) return 0;
        int min = numbers[0];
        int maxDiff = numbers[1] - min;
        for (int i = 2; i < numbers.length; i++) {
            if (min > numbers[i - 1])
                min = numbers[i - 1];
            int currentDiff = numbers[i] - min;
            if (currentDiff > maxDiff)
                maxDiff = currentDiff;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] a = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(_63_1_MaximalProfit.MaxDiff(a));
    }
}
