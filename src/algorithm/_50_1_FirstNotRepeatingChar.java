package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题50：第一个只出现一次的字符
 * 题目一：字符串中第一个只出现一次的字符
 * 在字符串中找出第一个只出现一次的字符。
 * 题目二：字符流中第一个只出现一次的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class _50_1_FirstNotRepeatingChar {
    //题目一
    public int FirstNotRepeatingChar(String str) {
        if (str.length() <= 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.containsKey(str.charAt(i)) ? map.get(str.charAt(i)) + 1 : 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
    //测试用例
    //https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

    //题目二
    ArrayList<Character> arrayList = new ArrayList<>();
    int[] chars = new int[256];
    int index = 0;

    {
        for (int i = 0; i < 256; i++)
            chars[i] = -1;
    }

    public void Insert(char ch) {
        if (chars[ch] == -1)
            chars[ch] = index;
        else if (chars[ch] >= 0)
            chars[ch] = -2;
        arrayList.add(ch);
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (chars[arrayList.get(i)] >= 0)
                return arrayList.get(i);
        }
        return '#';
    }
    //测试用例
    //https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
