package SITE02_programmers.level2;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12949
 */

public class Lesson_034_12949 {
    public static void main(String[] args) {
        Lesson_034_12949 lesson = new Lesson_034_12949();

        int[][] a = new int[][] { {1,4}, {3,2}, {4,1} };
        int[][] b = new int[][] { {3,3}, {3,3}};
        System.out.println(Arrays.deepToString(lesson.solution(a, b)));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;

                for(int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }

                answer[i][j] = sum;
            }
        }

        return answer;
    }
}