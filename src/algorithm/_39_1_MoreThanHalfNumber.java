package algorithm;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _39_1_MoreThanHalfNumber {
    public int MoreThanHalfNum_Solution(int[] array) {
        //return solution1(array);
        return solution2(array);
    }

    /**
     * 遍历数组保存两个值：数字和次数，与下一个数相同则加1，不同减1，次数为0保存当前数组，并设次数为1
     * 因为某个数的次数超过数组一半，所以最后设置的数字就是题目所求的数字
     *
     * @param array
     * @return
     */
    private int solution2(int[] array) {
        if (array.length == 0) return 0;
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) times++;
            else times--;
        }
        if (!CheckMoreThanHalf(array, array.length, result)) return 0;
        return result;
    }

    /**
     * 分析：一个数字的次数超过数字长度一半，意味着将这数组排序，该数组的中位数即为该数
     * 1.受快速排序的启发，先随机取一个数，将大于它的数放到右边，小于它的数放到左边，返回该数的下标
     * 2.把下标与length/2比较，若大于则中位数在左边，对其左边的数做1.操作，反之右边
     * 3.直到下标与length/2相等，此时该下标的数就是题目所找
     *
     * @param array
     * @return
     */
    private int solution1(int[] array) {
        if (array.length == 0) return 0;
        int length = array.length;
        int middle = length / 2;
        int start = 0;
        int end = length - 1;
        int index = Partition(array, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = Partition(array, start, end);
            } else {
                start = index + 1;
                index = Partition(array, start, end);
            }
        }
        int result = array[middle];
        if (!CheckMoreThanHalf(array, length, result))
            return 0;
        return result;
    }

    //检查是否超过数组一半
    private boolean CheckMoreThanHalf(int[] array, int length, int result) {
        int times = 0;
        for (int a : array
        ) {
            if (a == result)
                times++;
        }
        if (times * 2 > length) return true;
        else return false;
    }

    //将start所在位置的数字放到排序后的位置，并将其排序后的位置返回
    private int Partition(int[] array, int start, int end) {
        if (start >= end) return 0;
        int i = start;
        int j = end;
        int pivot = array[start];
        while (i < j) {
            while (i < j && array[j] >= pivot)
                j--;
            while (i < j && array[i] <= pivot)
                i++;
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, start, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //测试用例
    //https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
