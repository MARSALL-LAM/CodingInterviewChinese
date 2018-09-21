package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Marsall
 * Date: Create in 11:18 2018/9/21
 * 面试题56：数组中数字出现的次数
 * 题目一：数组中只出现一次的两个数字
 * 题目：一个整型数组除了两个数字之外，其他数字都出现两次，找出只出现一次的两个数字。
 * 要求时间复杂度O(n)，空间复杂度O(1)
 */
public class _56_1_NumbersAppearOnce {
    /**
     * 题目一
     * 分析：假如一个数组只有一个只出现过的数字，其他都出现两次，那么用异或操作可以找出这个数字
     * 相同数字做异或操作结果为0
     * 所以在本题我们需要把数组分为两部分，每部分都有一个只出现一次的数：
     * 分两部分的基准：将这两个只出现一次的数做异或操作，然后得到异或操作的结果从左到右的第一个为1的位置是否为1做基准分隔
     * 然后对两部分做一个数组只有一个出现过一次的操作
     *
     * @param array
     */
    static void FindNumbersAppearOnce(int[] array) {
        if (array.length < 2) return;
        if (!IsCorrectArray(array))return;;
            int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR = resultExclusiveOR ^ array[i];
        }
        int indexOf1 = FindFirstBitIs1(resultExclusiveOR);
        int num1 = 0;
        int num2 = 0;
        for (int j = 0; j < array.length; j++) {
            if (IsBit1(array[j], indexOf1))
                num1 = num1 ^ array[j];
            else
                num2 = num2 ^ array[j];
        }
        System.out.println(num1 + " " + num2);
    }

    private static boolean IsCorrectArray(int[] array) {
        Map<Integer, Boolean> map = new HashMap<>();
        int count = 0;
        for (int temp : array) {
            if (!map.containsKey(temp)) {
                count++;
                map.put(temp, true);
            } else
                count--;
        }
        return count == 2 ? true : false;
    }

    static private boolean IsBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 0 ? false : true;
    }

    static private int FindFirstBitIs1(int resultExclusiveOR) {
        int indexBit = 0;
        while (((resultExclusiveOR & 1) == 0) && (indexBit < 32)) {
            resultExclusiveOR >>= 1;
            ++indexBit;
        }
        return indexBit;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        FindNumbersAppearOnce(a);
    }
}
