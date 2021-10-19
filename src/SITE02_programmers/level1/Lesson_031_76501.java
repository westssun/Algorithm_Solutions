package SITE02_programmers.level1;

/**
 * 음양 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class Lesson_031_76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (!signs[i]) {
                sum += absolutes[i] * (-1);
            } else {
                sum += absolutes[i];
            }
        }

        return sum;
    }
}