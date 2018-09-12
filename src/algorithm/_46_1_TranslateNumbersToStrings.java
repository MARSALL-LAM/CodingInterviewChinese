package algorithm;

/**
 * 面试题46：把数字翻译成字符串
 * 题目：给定一个数字，我们按照如下规则把它翻译成字符串：
 * 0翻译成"a"，1翻译成"b"……，25翻译成"z"。
 * 一个数字可能有多个翻译。例如，12258有五种不同的翻译，分别为"bccfi","bwfi","bczi","mcfi","mzi"。
 * 请编写一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class _46_1_TranslateNumbersToStrings {
    /**
     * 分析：递归从最大的问题开始自上而下解决问题，会出现重复子问题。
     * 所以从最小的子问题开始从下而上解决问题。即从数字末尾开始，从右到左。
     */
    static int GetTranslationCount(int number) {
        if (number < 0) return 0;
        String numberInString = String.valueOf(number);
        return GetTranslationCount(numberInString);
    }

    static private int GetTranslationCount(String numberInString) {
        int length = numberInString.length();
        int[] counts = new int[length];
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            count = 0;
            if (i < length - 1)
                count = counts[i + 1];
            else
                count = 1;
            if (i < length - 1) {
                int digit1 = numberInString.charAt(i) - '0';
                int digit2 = numberInString.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 1)
                        count += counts[i + 2];
                    else
                        count += 1;
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }
    /**
     * 测试用例
     * 1.功能测试（只有一位数字；多为数字）
     * 2.特殊输入测试（负数；0；包含25、26的数字）
     */
    public static void main(String[] args){
        System.out.println(GetTranslationCount(12258));
    }
}
