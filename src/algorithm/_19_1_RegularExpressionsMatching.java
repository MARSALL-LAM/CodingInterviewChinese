package algorithm;

/**
 * 面试题19：正则表达式匹配
 * 题目：请实现一个函数用来匹配含'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示他前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符串匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class _19_1_RegularExpressionsMatching {
    /**
     * 分析：1.若pattern所在为'.'或者和str所在字符一样，则两者都进行下一字符的匹配
     * 2.若pattern所在的下一字符为'*'则有两种情况:
     * 2.1 所在字符为'.' 或者和str所在字符一样，则有三种情况
     * 2.1.1 pattern越过所在字符和'*'，不做匹配
     * 2.1.2 做一次匹配
     * 2.1.3 做多次匹配
     * 2.2 无法匹配则越过pattern所在字符和'*'
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return solution(str, 0, pattern, 0);
    }

    private boolean solution(char[] str, int strP, char[] pattern, int patP) {
        if (strP == str.length && patP == pattern.length) return true;
        if (strP != str.length && patP == pattern.length) return false;
        //pattern所在的下一字符为'*'
        if (patP < pattern.length - 1 && pattern[patP + 1] == '*') {
            //所在字符为'.' 或者和str所在字符一样
            if (strP < str.length && (pattern[patP] == '.' || str[strP] == pattern[patP])) {
                //pattern越过所在字符和'*'，不做匹配
                return solution(str, strP, pattern, patP + 2) ||
                        //做一次匹配
                        solution(str, strP + 1, pattern, patP + 2) ||
                        //做多次匹配
                        solution(str, strP + 1, pattern, patP);
            }
            //无法匹配则越过pattern所在字符和'*'
            else
                return solution(str, strP, pattern, patP + 2);
            //pattern所在为'.'或者和str所在字符一样，则两者都进行下一字符的匹配
        }
        if ((strP < str.length && (str[strP] == pattern[patP]) || pattern[patP] == '.'))
            return solution(str, strP + 1, pattern, patP + 1);
        return false;
    }
    //测试用例
    //https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=3
}
