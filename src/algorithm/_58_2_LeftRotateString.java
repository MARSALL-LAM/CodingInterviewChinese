package algorithm;

/**
 * Author: Marsall
 * Date: Create in 15:16 2018/9/21
 * 面试题58：翻转字符串
 * 题目二：左旋转字符串
 * 题目：如:输入"abcdef"和数字2，输出"cdefab"
 */
public class _58_2_LeftRotateString {
    static void Reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
    static void LeftRotateString(String str ,int n){
        char[] chars = str.toCharArray();
        Reverse(chars,0,n-1);
        Reverse(chars,n,chars.length-1);
        Reverse(chars,0,chars.length-1);
        System.out.println(String.valueOf(chars));
    }
    public static void main(String[] args) {
        String a = "i am a marshall";
        LeftRotateString(a,3);
    }
}
