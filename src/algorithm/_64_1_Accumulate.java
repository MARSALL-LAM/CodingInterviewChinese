package algorithm;

/**
 * Author: Marsall
 * Date: Create in 13:46 2018/9/25
 * 面试题64：求1+2+……+n
 * 题目：求1+2+……+n,要求不能使用乘除法、for、while、if、else、switch、case等关键字以及判断语句(A?b:c)
 */
public class _64_1_Accumulate {
    static int sum(int n) {
        int sum = n;
        boolean st = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(_64_1_Accumulate.sum(5));
    }

}
