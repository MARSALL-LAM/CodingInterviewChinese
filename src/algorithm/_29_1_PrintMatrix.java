package algorithm;

import java.util.ArrayList;

/**
 * 面试题29：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _29_1_PrintMatrix {
    /**
     * 分析：打印一圈 意味着两行两列，注意边界问题，难度不大
     *
     * @param matrix
     * @return
     */
    static public ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = 0;
        while (rows > start * 2 && cols > start * 2) {
            PrintMatrixInCircle(matrix, rows, cols, start, arrayList);
            start++;
        }
        return arrayList;
    }

    static private void PrintMatrixInCircle(int[][] matrix, int rows, int cols, int start, ArrayList<Integer> arrayList) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; i++) {
            arrayList.add(matrix[start][i]);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                arrayList.add(matrix[i][endX]);
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                arrayList.add(matrix[endY][i]);
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                arrayList.add(matrix[i][start]);
            }
        }
    }
    //测试用例
    //https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
}
