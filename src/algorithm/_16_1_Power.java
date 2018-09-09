package algorithm;

/**
 * 面试题16：数值的整数次方
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class _16_1_Power {
    /**
     * 分析：假设求一个数的32次方，相当于求这个数的16次方的平方，而16次方又是8次方的平方。
     * 所以求32次方只需要进行5次乘法
     * 假设次方为11  则二进制位 0000……00001011
     * 返回的结果就为base的8次方乘以base的2次方乘以base的1次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) return 0;
        double result = 1.0;
        int exponent1 = exponent;
        if (exponent < 0)
            exponent1 = -exponent;
        while (exponent1 != 0) {
            if ((exponent1 & 1) == 1)
                result *= base;
            //base=base的2的指数次方
            base *= base;
            exponent1 >>= 1;
        }
        return exponent < 0 ? 1 / result : result;
    }
    //测试用例
    //https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
