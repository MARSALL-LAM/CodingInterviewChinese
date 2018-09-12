package algorithm;

/**
 * 面试题44：数字序列中某一位的数字
 * 题目：数字以0123456789101112131415……的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计算）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字
 */
public class _44_1_DigitsInSequence {
    static public int digitAtIndex(int index) {
        if (index < 0)
            return -1;
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) return digitAtIndex(index, digits);
            index -= digits * numbers;
            digits++;
        }
    }

    static private int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    static private int beginNumber(int digits) {
        if (digits == 1) return 0;
        return (int) Math.pow(10, digits - 1);
    }

    static private int countOfIntegers(int digits) {
        if (digits == 1) return 10;
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }
    /**
     * 测试用例
     * 1.功能测试（10、190、1000……）
     * 2.边界值测试（0、1……）
     */
    public static void main(String[] args){
        System.out.println(digitAtIndex(-1));
        System.out.println(digitAtIndex(0));
        System.out.println(digitAtIndex(1));
        System.out.println(digitAtIndex(10));
        System.out.println(digitAtIndex(190));
        System.out.println(digitAtIndex(1000));

    }
}
