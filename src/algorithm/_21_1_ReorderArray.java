package algorithm;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数字，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，偶数位于数组的后半部分
 * （剑指offer上没有这个条件：并保证奇数和奇数，偶数和偶数之间的相对位置不变。）
 * 剑指offer的做法：类似快排，两个指针：一个从左、一个从右开始，左遇到偶数停下，右遇到奇数停下，交换
 */
public class _21_1_ReorderArray {
    /**
     * 牛客网多个条件：并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 分析：若无限制额外数据结构，则创建一个等大的数组，两个指针从左右扫描
     * 左指针遇到奇数就放入左边，右指针遇到偶数就放右边
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        solution1(array);
    }

    private void solution1(int[] array) {
        int[] cp = new int[array.length];
        int left = 0, right = cp.length - 1;
        for (int i = 0, j = array.length - 1; i < array.length && j >= 0 && left <= right; i++, j--) {
            if (array[i] % 2 == 1) cp[left++] = array[i];
            if (array[j] % 2 == 0) cp[right--] = array[j];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = cp[i];
        }
    }
    //测试用例
    //https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
