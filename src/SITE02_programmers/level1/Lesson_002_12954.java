package SITE02_programmers.level1;

/**
 * x만큼 간격이 있는 n개의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class Lesson_002_12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long result = 0;
        for (int i = 0; i < n; i++) {
            result = result + x;

            answer[i] = result;
        }

        return answer;
    }
}
