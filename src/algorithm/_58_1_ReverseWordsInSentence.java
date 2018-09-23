package algorithm;

/**
 * Author: Marsall
 * Date: Create in 14:29 2018/9/21
 * 面试题58：翻转字符串
 * 题目一：翻转单词顺序
 * 题目:翻转单词顺序，但单词字母顺序不变
 */
public class _58_1_ReverseWordsInSentence {
    /**
     * 分析：先翻转整个字符串，在翻转单词
     */
    static void Reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    static void ReverseSentence(char[] chars) {
        if (chars.length <= 0) return;
        int start = 0;
        int end = 0;
        int length = chars.length;
        System.out.println(String.valueOf(chars));
        while (start < length) {
            if (end == length || chars[end] == ' ') {
                Reverse(chars, start, end-1 );
                end++;
                start = end;
            } else
                end++;
        }
        System.out.println(String.valueOf(chars));
    }

    public static void main(String[] args) {
        String a = "i am a marshall";
        ReverseSentence(a.toCharArray());
    }
}
