package algorithm;

/**
 * 面试题43:1--n整数中1出现的次数
 * 题目：求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class _43_1_NumberOf1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        return NumberOfXBetween1AndN_Solution(n, 1);
    }


    public int NumberOfXBetween1AndN_Solution(int n, int x) {
        if (n < 0 || x < 1 || x > 9)
            return 0;
        int high, low, curr, tmp, i = 1;
        high = n;
        int total = 0;
        while (high != 0) {
            high = n / (int) Math.pow(10, i);// 获取第i位的高位
            tmp = n % (int) Math.pow(10, i);// 获取第i位以及之后的位
            curr = tmp / (int) Math.pow(10, i - 1);// 获取第i位
            low = tmp % (int) Math.pow(10, i - 1);// 获取第i位的低位
            if (curr == x) {
                total += high * (int) Math.pow(10, i - 1) + low + 1;
            } else if (curr < x) {
                total += high * (int) Math.pow(10, i - 1);
            } else {
                total += (high + 1) * (int) Math.pow(10, i - 1);
            }
            i++;
        }
        return total;
    }

   //测试用例
    //https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
