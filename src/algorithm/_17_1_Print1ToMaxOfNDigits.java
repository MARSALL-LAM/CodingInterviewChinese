package algorithm;

/**
 * 面试题17：打印从1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1到最大的n位十进制数。
 */
public class _17_1_Print1ToMaxOfNDigits {
    /**
     * 分析：每个位的数字都可以用字符'0'-'9'表示，所以用字符串表示可以避免大数
     * @param n
     */
    public static void solution(int n) {
        if (n <= 0) {
            return;
        }
        StringBuffer s = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            s.append('0');
        }
        for (int i = 0; i < 10; i++) {

            s.setCharAt(0, (char) (i + '0'));
            Print1ToMaxOfNDigitsRecursely(s, n, 0);
        }

    }

    public static void Print1ToMaxOfNDigitsRecursely(StringBuffer s, int n, int index) {
        if (index == n - 1) {
            PrintNumber(s);
            return;
        }

        for (int i = 0; i < 10; i++) {
            s.setCharAt(index + 1, (char) (i + '0'));
            Print1ToMaxOfNDigitsRecursely(s, n, index + 1);
        }
    }

    public static void PrintNumber(StringBuffer s) {
        boolean isBeginning0 = true;
        for (int i = 0; i < s.length(); i++) {
            if (isBeginning0 && s.charAt(i) != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(s.charAt(i));
            }
        }

        System.out.println();
    }

    /**
     * 测试用例
     * 1.功能测试
     * 2.特殊测试（0,-1)
     */
    public static void main(String[] args) {
        _17_1_Print1ToMaxOfNDigits.solution(-1);
        _17_1_Print1ToMaxOfNDigits.solution(0);
        _17_1_Print1ToMaxOfNDigits.solution(3);
    }
}
