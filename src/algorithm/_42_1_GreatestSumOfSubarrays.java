package algorithm;

/**
 * 面试题42：连续子数组的最大和
 * 题目：数组有正数和负数，数组中的一个或连续多个正数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)
 */
public class _42_1_GreatestSumOfSubarrays {
    //注意全为负数的情况
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int tempMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (tempMax <= 0)
                tempMax = array[i];
            else
                tempMax += array[i];
            if (tempMax > max)
                max = tempMax;
        }
        return max;
    }
    //测试用例
    //https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
