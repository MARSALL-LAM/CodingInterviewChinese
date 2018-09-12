package algorithm;

/**
 * 题目48：最长不含重复字符的子字符串
 * 题目：从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class _48_1_LongestSubstringWithoutDup {
    static int longestSubstringWithoutDuplication(String str) {
        int curLength = 0;
        int maxLength = 0;
        int[] postion = new int[26];
        for (int i = 0; i < postion.length; i++)
            postion[i] = -1;
        for (int i = 0; i < str.length(); i++) {
            int prevIndex = postion[str.charAt(i) - 'a'];
            if (prevIndex < 0 || i - prevIndex > curLength)
                ++curLength;
            else {
                if (curLength > maxLength)
                    maxLength = curLength;
                curLength = i - prevIndex;
            }
            postion[str.charAt(i) - 'a'] = i;
        }
        if (curLength > maxLength)
            maxLength = curLength;
        return maxLength;
    }
    /**
     * 测试用例
     * 1.功能测试（多个字符的字符串；一个字符；所有字符都唯一；所有字符都相同）
     * 2.特殊（空）
     */
}
