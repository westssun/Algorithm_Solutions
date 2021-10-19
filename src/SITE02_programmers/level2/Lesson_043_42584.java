package SITE02_programmers.level2;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */

public class Lesson_043_42584 {
    public static void main(String[] args) {
        Lesson_043_42584 lesson = new Lesson_043_42584();
        int[] a = new int[]{1,2,3,2,3};

        System.out.println(Arrays.toString(lesson.solution(a)));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int current = prices[i];

            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (current > prices[j]) {
                    cnt += 1;
                    answer[i] = cnt;
                    break;
                } else {
                    cnt += 1;
                }

                answer[i] = cnt;
            }
        }

        return answer;
    }
}