package algorithm;

/**
 * 面试题53：在排序数组中查找数字
 * 题目一：数字在排序数组中出现的次数。
 * 题目：统计一个数字在排序数组中出现的次数。
 * 例如：输入排序数组{1,2,3,4,4,4,4,5}和数字4，输出4.
 */
public class _53_1_FindNumberInSortedArray {
    static int GetNumberOfK(int[] sortedArray, int k) {
        int number = 0;
        if (sortedArray.length > 0) {
            int first = GetFirstKCore(sortedArray, sortedArray.length, k, 0, sortedArray.length - 1);
            int last = GetLastKCore(sortedArray, sortedArray.length, k, 0, sortedArray.length - 1);
            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;
    }

    private static int GetLastKCore(int[] sortedArray, int length, int k, int start, int end) {
        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        int middleData = sortedArray[middleIndex];
        if (middleData == k) {
            if ((middleIndex < length - 1 && sortedArray[middleIndex + 1] != k) || middleIndex == length - 1)
                return middleIndex;
            else
                start = middleIndex + 1;
        } else if (middleData < k)
            start = middleIndex + 1;
        else
            end = middleIndex - 1;
        return GetLastKCore(sortedArray, length, k, start, end);
    }

    private static int GetFirstKCore(int[] sortedArray, int length, int k, int start, int end) {
        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        int middleData = sortedArray[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && sortedArray[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else
                end = middleIndex - 1;
        } else if (middleData > k)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;
        return GetFirstKCore(sortedArray, length, k, start, end);
    }

    /**
     * 测试用例：
     * 1.功能测试
     * 2.边界值测试
     * 3.特殊输入测试
     * @param args
     */
    public static void main(String[] args){
        int[] a = {1,1,1,1,1,1,3,3,2,3,2,32,3,3};
        System.out.println(_53_1_FindNumberInSortedArray.GetNumberOfK(a,3));
    }
}
