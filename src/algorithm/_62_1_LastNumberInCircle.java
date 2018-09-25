package algorithm;

import java.util.ArrayList;

/**
 * Author: Marsall
 * Date: Create in 12:21 2018/9/25
 * 面试题62：圆圈中最后剩下的数字
 * 题目：0,1,……,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈删除第m个数字。
 * 求出这个圆圈剩下的最后一个数字。
 */
public class _62_1_LastNumberInCircle {
    /**
     * 约瑟夫环问题
     * 分析：解法1：经典解法，用环形款表模拟圆圈
     * 解法2：数学规律 f=(n,m)=[f(n-1,+m)+m]&n
     */
    static int LastRemaining(int n, int m) {
//        boolean[] isAlive = new boolean[n];
//        for (int i = 0; i < n; i++)
//            isAlive[i] = true;
//        int countN = 0;
//        int Index = 0;
//        int countDead = 0;
//        while (countDead < n - 1) {
//            countN++;
//            if (countN == m) {
//                countDead += 1;
//                countN = 0;
//                isAlive[Index % n] = false;
//            }
//            while (isAlive[(Index + 1) % n] == false)
//                Index += 1;
//            Index++;
//        }
//        for (int i = 0; i < n; i++)
//            if (isAlive[i] == true)
//                return i;
//        return 0;
        if (n < 1 || m < 1) return -1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arrayList.add(i);
        int Index = 0;
        while (arrayList.size() > 1) {
            for (int i = 1; i < m; i++) {
                Index++;
                if (Index >= arrayList.size())
                    Index = Index % arrayList.size();
            }
            arrayList.remove(Index);
        }
        return arrayList.get(0);
    }

    static int LastRemaining2(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(a[_62_1_LastNumberInCircle.LastRemaining(9, 3)]);
        System.out.println(a[_62_1_LastNumberInCircle.LastRemaining2(9, 3)]);
    }
}
