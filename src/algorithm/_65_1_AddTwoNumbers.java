package algorithm;

/**
 * Author: Marsall
 * Date: Create in 14:12 2018/9/25
 * 面试题65：不用加减乘除做加法
 */
public class _65_1_AddTwoNumbers {
    /**
     * 三步走策略：第一步做各位相加不进位
     * 第二步做进位
     * 第三步把前面两个结果加起来
     */
    static int add(int a, int b) {
        int sum = 0;
        int carry = 0;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(_65_1_AddTwoNumbers.add(2, 6));
    }

}
