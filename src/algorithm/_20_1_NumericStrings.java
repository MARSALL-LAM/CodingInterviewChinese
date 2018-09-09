package algorithm;

/**
 * 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小树）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class _20_1_NumericStrings {
    /**
     * 分析：A[.[B]][e|EC]或者.B[e|EC],A为整数部分，B为小数部分，C为e|E的指数部分
     *
     * @param str
     * @return
     */
    int position = 0;

    public boolean isNumeric(char[] str) {
        if (str.length <= 0) return false;
        boolean numeric = scanInteger(str);
        //如果出现'.'，则接下来是数字的小数部分
        if (position < str.length && str[position] == '.') {
            position++;
            //用||的原因是小数可以没有整数部分
            numeric = scanUnsignedInteger(str) || numeric;
        }
        //出现'e'或者'E'，接下来是数字的指数部分
        if (position < str.length && (str[position] == 'e' || str[position] == 'E')) {
            position++;
            //用&&的原因是e前后都要有数字
            numeric = numeric && scanInteger(str);
        }
        int end = position;
        position = 0;
        return numeric && end == str.length;

    }

    //扫描0--9，直到遇到不是0--9的字符
    private boolean scanInteger(char[] str) {
        if (position >= str.length) return false;
        if (str[position] == '+' || str[position] == '-') position++;
        return scanUnsignedInteger(str);
    }

    //判断符号
    private boolean scanUnsignedInteger(char[] str) {
        if (position >= str.length) return false;
        int before = position;
        while (position != str.length && str[position] >= '0' && str[position] <= '9')
            position++;
        return position > before;
    }
}
