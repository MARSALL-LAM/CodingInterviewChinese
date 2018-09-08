package algorithm;

/**
 * 面试题05：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"
 * 例如：输入"we are"，输出"we%20are"
 */
public class _05_01_ReplaceSpace {
    /**
     * 分析：如果从左到右每次替换空格（一个字符）为%20(三个字符)，则空格后面的字符都要往后移动一次，时间复杂度为O(n*n)
     * 如果从右到左替换，则每个字符只用移动一次，时间复杂度为O(n)
     *
     * @param str
     * @return
     */
    public String solution(StringBuffer str) {
        if (str == null || str.length() == 0) return "";
        int strl = str.length(), spacel = 0;
        for (int i = 0; i < strl; i++) {
            if (str.charAt(i) == ' ')
                spacel++;
        }
        int len = strl + 2 * spacel;
        char[] chars = new char[len];
        char temp;
        for (int i = str.length() - 1; i >= 0 && len > 0; i--) {
            temp = str.charAt(i);
            if (temp == ' ') {
                chars[--len] = '0';
                chars[--len] = '2';
                chars[--len] = '%';
            } else chars[--len] = temp;
        }
        return String.valueOf(chars);
    }

    /**
     * 测试用例：
     * 1.输入的字符串包含空格（最前，最后，中间，连续）
     * 2.输入的字符串不包含空格
     * 3.特殊输入测试（null）
     *
     * @param args
     */
    //测试用例
    //https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
    public static void main(String[] args) {
        _05_01_ReplaceSpace a = new _05_01_ReplaceSpace();
        StringBuffer str = new StringBuffer("hello world");
        StringBuffer str1 = new StringBuffer("");
        StringBuffer str2 = new StringBuffer("helloworld ");
        StringBuffer str3 = new StringBuffer(" helloworld");
        StringBuffer str4 = new StringBuffer("hello   world");
        System.out.println(a.solution(str));
        System.out.println(a.solution(str1));
        System.out.println(a.solution(str2));
        System.out.println(a.solution(str3));
        System.out.println(a.solution(str4));
    }
}
