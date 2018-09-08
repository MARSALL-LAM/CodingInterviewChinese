package algorithm;

/**
 * 面试题04：二位数组的查找
 * 题目：在一个二位数组中，每一行都按照从左到右递增的顺序排序，没一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class _04_01_FindInPartiallySortedMatrix {
    /**
     * 分析：为了快速地判断target的范围，选择左下（或者右上，与左下类似）为开始
     *      以左下array[i=row][j=0]为例，在i行中array[i][j]最小，在[j]列中最大
     *      每次将左下的数与target比较：1.target大于左下数，则j++;
     *                                  2.target小于左下数，则i--；
     *                                  3.等于则返回true；
     *      这种方法避免了左上（右下）每次都要与行和列上的元素比较
     * @param array
     * @param target
     * @return
     */
    public boolean solution(int[][] array,int target){
        if (array == null || array.length <= 0 )return false;
        int row = array.length;
        int col = array[0].length;
        int i = row-1, j = 0;
        while (i >= 0 && j <col){
            if (target == array[i][j])return true;
            else if (target > array[i][j])j++;
            else i--;
        }
        return false;
    }
    /**
     * 测试用例：
     * 1.二维数组包含查找的数字
     * 2.二维数组不包含查找的数字
     * 3.特殊输入测试（空数组）
     */
    public static void main(String[] args){
        _04_01_FindInPartiallySortedMatrix a = new _04_01_FindInPartiallySortedMatrix();
        int[][] array = {{1,6,3},{4,12,4}};
        int[][] nul = new int[11][11];
        System.out.println(a.solution(array,12));
        System.out.println(a.solution(array,9));
        System.out.println(a.solution(nul,2));
    }
}
