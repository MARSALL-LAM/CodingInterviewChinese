package algorithm;

/**
 * Author: Marsall
 * Date: Create in 13:43 2018/9/21
 * 面试题57：和为s的数
 * 题目一：和为s的两个数字
 * 题目：输入一个递增排序的数组和一个数字s,在数组中查找两个数，使得他们的和正好是s。如果有多对数字的和等于s，任意输出一组即可。
 */
public class _57_1_TwoNumbersWithSum {
    /**
     * 分析：暴力解法O(n*n)
     * 根据递增性质，从最左和最右开始往中间走，直到遇到和为s
     */
    static void FindNumbersWithSum(int[] array, int s) {
        if (array.length < 2) return;
        boolean ii = false;
        boolean jj = false;
        int i = 0;
        int j = array.length - 1;
        int num1 = -1;
        int num2 = -1;
        while (i < j) {
            int sum = array[i] + array[j];
            if (sum > s) j--;
            else if (sum < s) i++;
            else {
                num1 = array[i];
                num2 = array[j];
                ii = true;
                jj = true;
                break;
            }
        }
        if (ii == true && jj == true)
            System.out.println(num1 + " " + num2);
    }

    public static void main(String[] args) {
        int[] a = {-1, -3, 5, 6, 7, 9, 11, 13};
        FindNumbersWithSum(a, -4);
    }
}
