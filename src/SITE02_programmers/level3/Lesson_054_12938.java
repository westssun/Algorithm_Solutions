package SITE02_programmers.level3;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12938
 */

public class Lesson_054_12938 {
    public static void main(String[] args) {
        Lesson_054_12938 lesson = new Lesson_054_12938();

        System.out.println(Arrays.toString(lesson.solution(4, 13)));
    }

    public int[] solution(int n, int s) {
        /**
         * 문제 이해: n개의 숫자 간의 차이가 작을수록 최고의 집합이다.

         * 예시) n=4, s=13일 경우
         * 1. 몫 : 13/4 = 3
         * 2. 나머지 : 1
         *
         * [3, 3, 3, 4]
         * 나머지 (1) 횟수만큼 3 + 1 insert
         * 그 외 몫을 insert
         */
        int Q = s / n; /* 1. 몫 */
        int R = s % n; /* 2. 나머지 */

        int[] answer = {};

        if (Q == 0) { /* 덧셈을 만들 수 없음 */
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[n];
        }

        /* answer 배열 insert 시작 */
        for (int i = 0; i < n; i++) {
            if (R > 0) { /* 나머지가 0보다 클 경우 */
                if (i < n - R) { /* n - R 보다 작을 경우에 몫을 insert */
                    answer[i] = Q;
                } else { /* R 만큼 Q + 1 값이 insert 된다 */
                    answer[i] = Q + 1;
                }
            } else { /* 나머지가 0보다 크지 않을땐 나누어떨어졌다는 이야기이므로, 몫만 insert */
                answer[i] = Q;
            }
        }

        return answer;
    }
}