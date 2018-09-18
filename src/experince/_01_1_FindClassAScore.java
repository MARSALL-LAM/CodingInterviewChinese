package experince;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 笔试经验01：找出重本线
 * 题目：现有一个score.txt，内容为一百万条按考号排序的高考成绩（用','号分隔字段）：
 * 0000001,张三,575
 * 0000002,李四,673
 * 规定前%15为重本分数，求出重本线
 */
public class _01_1_FindClassAScore {
    static int FindClassAScore(File filePath, float percent) throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String string;
            while ((string = br.readLine()) != null) {
                String[] strings = string.split(",");
                priorityQueue.offer(Integer.valueOf(strings[2]));
            }
        }
        int position = (int) (priorityQueue.size() * percent);
        int i = 0;
        int line = 0;
        while (!priorityQueue.isEmpty() && i < position) {
            line = priorityQueue.poll();
        }
        return line;
    }
}
