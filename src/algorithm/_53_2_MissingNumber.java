package algorithm;

/**
 * 面试题53：在排序数组中查找数字
 * 题目二：0--n-1中缺失的数字
 * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0--n-1之内。
 * 在范围0--n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class _53_2_MissingNumber {
    static int GetMissingNumber(int[] numbers) {
        int length = numbers.length;
        if (length <= 0) return -1;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = (right + left) >> 1;
            if (numbers[middle] != middle) {
                if (middle == 0 || numbers[middle - 1] == middle - 1)
                    return middle;
                right = middle - 1;
            } else
                left = middle + 1;
        }
        //当n-1不存在的情况
        if (left == length)
            return length;

        return -1;
    }

    /**
     * 测试用例：
     * 1.功能测试
     * 2.边界值测试（只有一个数字0）
     * 3.特殊输入测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {0};
        System.out.println(_53_2_MissingNumber.GetMissingNumber(a));
    }
}
