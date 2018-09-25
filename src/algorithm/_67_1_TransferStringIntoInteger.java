package algorithm;

/**
 * Author: Marsall
 * Date: Create in 15:29 2018/9/25
 * 面试题67：将字符串转换成整数
 */
public class _67_1_TransferStringIntoInteger {
    /**
     * 分析：实现很简单，需要注意各种输入，如非数字，空字符串，加减号，是否溢出等
     */
    static int state = -1;

    enum Status {
        VALID(-1, "正常"),
        INVALID(0, "非法输入"),
        OVERFLOW(1, "超出整型范围");

        private int state;
        private String stateInfo;

        Status(int state, String stateInfo) {
            this.state = state;
            this.stateInfo = stateInfo;
        }

        static String getStateInfo(int state) {
            Status[] values = values();
            for (int i = 0; i < values.length; i++)
                if (state == values[i].state)
                    return values[i].stateInfo;
            return "NOT FIND";
        }
    }

    static int StrToInt(String str) {
        if (str == null || str == "") {
            state = 0;
            return 0;
        }
        int sum = 0;
        char[] chars = str.toCharArray();
        int i = 0;
        int sign = 1;
        if (chars[i] == '-' || chars[i] == '+') {
            sign = (chars[i] == '-' ? -1 : 1);
            i++;
        }
        for (; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                state = 0;
                return 0;
            }
            int digit = chars[i] - '0';
            if (Integer.MAX_VALUE / 10 < sum || (Integer.MAX_VALUE / 10 == sum && Integer.MAX_VALUE % 10 < digit)) {
                state = 1;
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            sum = sum * 10 + digit;
        }
        return sum * sign;
    }

    public static void main(String[] args) {
        System.out.println(_67_1_TransferStringIntoInteger.StrToInt("-0"));
        System.out.println(Status.getStateInfo(_67_1_TransferStringIntoInteger.state));
    }

}
