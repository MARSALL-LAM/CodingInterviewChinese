package algorithm;

/**
 * 面试题51：数组中的逆序对
 * 题目：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class _51_1_InversePairs {
    public int InversePairs(int[] array) {
        if (array.length < 0) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairs(array, copy, 0, array.length - 1);
        return count;
    }

    private int InversePairs(int[] array, int[] copy, int start, int end) {
        if (start == end) return 0;
        int mid = (end - start) >> 1;
        int left = InversePairs(array, copy, start, start + mid)%1000000007;
        int right = InversePairs(array, copy, start + mid + 1, end)%1000000007;
        int i = start + mid;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + mid + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - mid;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            } else
                copy[indexCopy--] = array[j--];
        }
        for (;i >= start;i--)
            copy[indexCopy--] = array[i];
        for (;j>=start+mid+1;j--)
            copy[indexCopy--] = array[j];
        for (int k = start;k <= end; k++)
              array[k] = copy[k];
        return (left+right+count)%1000000007;
    }
}
