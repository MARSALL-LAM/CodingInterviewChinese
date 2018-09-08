package algorithm;

/**
 * 面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一格机器人从坐标(0,0)的格子开始移动，
 * 它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class _13_1_RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
        boolean flag[][] = new boolean[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int row, int col, int rows, int cols, boolean[][] flag, int threshold) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || numSum(row) + numSum(col)  > threshold || flag[row][col] == true) return 0;
        flag[row][col] = true;
        return helper(row - 1, col, rows, cols, flag, threshold)
                + helper(row + 1, col, rows, cols, flag, threshold)
                + helper(row, col - 1, rows, cols, flag, threshold)
                + helper(row, col + 1, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        do{
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;
    }
    //测试用例
    //https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
}
