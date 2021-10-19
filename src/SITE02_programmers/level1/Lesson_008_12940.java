package SITE02_programmers.level1;

import java.util.Arrays;

/**
 * 최대공약수와 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 */
public class Lesson_008_12940 {
    public static void main(String[] args) {
        Lesson_008_12940 lesson = new Lesson_008_12940();

        int[] result = lesson.solution(12, 36);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int n, int m) {
        int[] answer = {};

        answer = test(n, m);


        return answer;
    }

    public static int[] test(int a, int b) {
        int[] result = new int[2];

        /* 작은수를 왼쪽으로 */
        if (b == Integer.min(a, b)) {
            int temp = a;
            a = b;
            b = temp;
        }

        /* a, b 를 나눠서 나누어떨어지면 최대공약수 : a, 나머지가 생기면 최대공약수 함수 호출 */
        if (b % a == 0) {
            result[0] = a;
        } else {
            /* 함수 호출 */
            int n = b; /* 큰수를 n으로 */
            int m = a; /* 작은수를 a로 */
            result[0] = gcd(n, m);
        }

        /* 최대공약수로 각 나눈 수를 곱한다 */
        result[1] = result[0] * (a / result[0]) * (b / result[0]);

        return result;
    }

    /**
     * 최대공약수 구하는 함수
     * @param a
     * @param b
     * @return
     */
    static int gcd (int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}