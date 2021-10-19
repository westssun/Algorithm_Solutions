package SITE02_programmers.level2;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12941
 */

public class Lesson_036_12941 {
    public static void main(String[] args) {
        Lesson_036_12941 lesson = new Lesson_036_12941();

        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        System.out.println(lesson.solution(a, b));
    }

    public int solution(int[] A, int[] B)
    {
        int answer = 0;

        // 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        /* A의 가장 최소값과 B의 가장 최대값 */
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - (i + 1)];
        }

        return answer;
    }
}