package algorithm;

import java.util.*;

/**
 * Author: Marsall
 * Date: Create in 11:22 2018/9/25
 * 面试题61：扑克牌中的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2--10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
 */
public class _61_1_ContinousCards {
    /**
     * 分析：将王用0代替
     * 判断是不是顺子，则先将数组排序，若有相同的非0数字则false；
     * 若两张牌的差值大于0的个数则false
     */
    static boolean isContinousCards(List<Integer> numbers) {
        if (numbers.size() < 5) return false;
        int numberOfZero = 0;
        int numberOfGap = 0;
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size() && numbers.get(i) == 0; i++)
            numberOfZero += 1;

        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.size()) {
            if (numbers.get(small) == numbers.get(big))
                return false;
            numberOfGap += numbers.get(big) - numbers.get(small) - 1;
            small = big;
            big++;
        }
        return numberOfGap > numberOfZero ? false : true;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(4);
        list.add(5);
        System.out.println(_61_1_ContinousCards.isContinousCards(list));
    }
}
