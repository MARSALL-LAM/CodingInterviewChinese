package algorithm;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class _49_1_UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int two = 0;
        int three = 0;
        int five = 0;
        int[] numbers = new int[index];
        numbers[0] = 1;
        int i = 1;
        while (i < index) {
            numbers[i] = Math.min(numbers[two] * 2, Math.min(numbers[three] * 3, numbers[five] * 5));
            if (numbers[i] == numbers[two] * 2) two++;
            if (numbers[i] == numbers[three] * 3) three++;
            if (numbers[i] == numbers[five] * 5) five++;
            i++;
        }
        return numbers[index - 1];
    }
}
