package algorithm;

/**
 * Author: Marsall
 * Date: Create in 14:33 2018/9/25
 * 面试题66：构建乘积数组
 * 题目：给定一个数组A[0,1,……,n-1]，请构建一个数组B[0,1……,n-1]
 * 其中B中的元素B[i] = A[0]xA[1]x……xA[i-1]xA[i+1]x……xA[n-1]。不能使用除法。
 */
public class _66_1_ConstructArray {
    /**
     * 分析：分0--i-1和i+1--n-1两部分
     */
    static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++)
            B[i] = B[i - 1] * A[i - 1];
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        for (int i = 0; i < B.length; i++)
            System.out.println(B[i]);
        return B;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        _66_1_ConstructArray.multiply(a);
    }
}
