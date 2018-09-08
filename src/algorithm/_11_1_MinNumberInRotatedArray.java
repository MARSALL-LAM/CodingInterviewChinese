package algorithm;

/**
 * 面试题11：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数字的一个旋转，输出旋转数组的最小元素。
 */
public class _11_1_MinNumberInRotatedArray {
    /**
     * 分析：特点：最小元素左边的元素左右两边的元素都大于它
     * 最小元素左边的元素均大于第一个和最后一个的元素
     * 最小元素右边的元素大于其左边小于右边
     * <p>
     * 二分查找法： array[indexM]>=array[indexL] 则往右缩进 indexL = indexM
     * array[indexM]=<array[indexR] 则往左缩进 indexR = indexM
     * 若array[indexM]==array[indexR]==array[indexL]则在indexL-indexR范围顺序查找min
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length <= 0) return -1;
        int indexL = 0, indexR = array.length - 1, indexM = indexL;
        while (array[indexL] >= array[indexR]) {
            if (indexR - indexL == 1) {
                indexM = indexR;
                break;
            }
            indexM = (indexL + indexR) / 2;
            if (array[indexM] == array[indexL] && array[indexM] == array[indexR]) {
                return minInOrder(array, indexL, indexR);
            }
            if (array[indexM] >= array[indexL]) {
                indexL = indexM;
            } else if (array[indexM] <= array[indexR])
                indexR = indexM;
        }
        return array[indexM];
    }

    private int minInOrder(int[] array, int indexL, int indexR) {
        int min = array[indexL];
        for (int i = indexL + 1; i < indexR; i++) {
            if (min > array[i])
                min = array[i];
        }
        return min;
    }
    //测试用例
    //https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
