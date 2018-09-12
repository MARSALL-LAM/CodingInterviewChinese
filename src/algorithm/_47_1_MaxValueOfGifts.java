package algorithm;

/**
 * 面试题47：礼物的最大价值
 * 题目：在一个mn的棋盘的每一格都放一个礼物，每个礼物都有一定的价值（大于0）
 * 从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，计算最多能拿到多少价值的礼物？
 */
public class _47_1_MaxValueOfGifts {
    static int getMaxValue(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;
        if (rows <= 0 || cols <= 0) return 0;
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxValues[j];
                if (j > 0)
                    left = maxValues[j - 1];
                maxValues[j] = Math.max(left, up) + values[i][j];
            }
        }
        int maxValue = maxValues[cols - 1];
        return maxValue;
    }

}
