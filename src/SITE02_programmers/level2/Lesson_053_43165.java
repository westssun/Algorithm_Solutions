package SITE02_programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */

public class Lesson_053_43165 {
    static int targetValue;
    static int cnt;
    static int[] arr;
    static int[] sign;

    public static void main(String[] args) {
        Lesson_053_43165 lesson = new Lesson_053_43165();

        int[] a = new int[]{1,1,1,1,1};
        System.out.println(lesson.solution(a, 3));
    }

    public int solution(int[] numbers, int target) {
        targetValue = target;
        arr = numbers;
        sign = new int[arr.length];

        for (int i = 0; i <numbers.length; i++) {
            sign[i] = 1;
        }

        dfs(0);

        return cnt;
    }

    static void dfs(int value) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] * sign[i]);
        }

        if (sum == targetValue) {
            cnt++;
        }

        /* 재귀함수 */
        for (int j = value; j < arr.length; j++) {
            sign[j] = -1;
            dfs(j + 1);

            sign[j] = 1;
        }
    }
}