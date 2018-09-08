package algorithm;

/**
 * 面试题3：数组中重复的数字
 * 题目一：找出数组中重复数字。
 * 在一个长度为n的数组里的所有数字都在0--n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}那么对应得输出是重复的数字2或者3.
 */

public class DuplicationInArray {
    /**
     *分析：因为所有数字在范围0--n-1，即如果没有重复的数字，则n会位于n-1的位置上。
     *      通过遍历数组，当当前下标i不等于array[i]时做以下操作
     *          1.把array[i]与array[array[i]]比较:如果相等则重复了,return array[i]；
     *          2.交换该两元素
     *      时间复杂度为O(n),空间复杂度为O(1)
     * @param array
     * @return
     */
    public int solution(int[] array){
        if (array.length<=0 || array == null)return -1;
        int length = array.length;
        for (int i = 0;i < length;i++) {
            if (array[i] < 0 || array[i] > length - 1)
                return -2;
        }
        for (int i = 0;i < length;i++){
            while(array[i] != i){
                if (array[i] == array[array[i]]){
                    return array[i];
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return -3;
    }
    public static void main(String[] args){
        DuplicationInArray duplicationInArray = new DuplicationInArray();
        int[] array = {1,2,1,3,0,3,1};
        int r = duplicationInArray.solution(array);
        System.out.println(r>0?r:(r==-1?"Array Error":(r==-2)?"Element Error":"No Duplication"));
    }
}