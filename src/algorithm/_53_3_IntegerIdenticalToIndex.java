package algorithm;

/**
 * 面试题53：在排序数组中查找数字
 * 题目三：数组中数值和下标相等的元素
 * 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程一个函数，找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组{-3,-1,1,3,5}中，数字3和他的下标相同
 */
public class _53_3_IntegerIdenticalToIndex {
    static int GetNumberSameAsIndex(int[] numbers) {
        int length = numbers.length;
        if (length <= 0) return -1;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (numbers[middle] == middle)
                return middle;
            if (numbers[middle] > middle)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}
