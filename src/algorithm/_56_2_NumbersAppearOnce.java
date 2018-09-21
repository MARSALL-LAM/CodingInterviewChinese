package algorithm;

/**
 * Author: Marsall
 * Date: Create in 12:57 2018/9/21
 * 面试题56：数组中数字出现的次数
 * 题目二：数组中唯一只出现一次的数字
 * 题目：在一个数组中除了一个数字只出现一次，其他都出现了三次。
 */
public class _56_2_NumbersAppearOnce {
     static int FindNumberAppearingOnce(int[] array) {
        if (array.length <= 0) return -1;
        int[] bitSum = new int[32];
        for (int i = 0; i < array.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = array[i] & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
    public static void main(String[] args){
         int[] a = {-1,-1,-1,1};
         System.out.println(FindNumberAppearingOnce(a));
    }

}
