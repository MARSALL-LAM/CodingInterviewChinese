package algorithm;

/**
 * 面试题12：矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某个字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该各自
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class _12_1_StringPathInMatrix {
    /**
     * 回溯法
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length <= 0 || rows < 1 || cols < 1 || str.length <= 0 || matrix.length != rows * cols) return false;
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, i, rows, j, cols, str, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int row, int rows, int col, int cols, char[] str, int strP, boolean[] visited) {
        if (row < 0 || row > rows - 1 || col < 0 || col > cols - 1 || visited[row * cols + col] == true || str[strP] != matrix[row * cols + col])
            return false;
        if (strP == str.length - 1) return true;
        visited[row * cols + col] = true;
        if (hasPathCore(matrix, row - 1, rows, col, cols, str, strP + 1, visited) ||
                hasPathCore(matrix, row + 1, rows, col, cols, str, strP + 1, visited) ||
                hasPathCore(matrix, row, rows, col - 1, cols, str, strP + 1, visited) ||
                hasPathCore(matrix, row, rows, col + 1, cols, str, strP + 1, visited))
            return true;
        visited[row * cols + col] = false;
        return false;
    }
    //测试用例
    //https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=4
}
