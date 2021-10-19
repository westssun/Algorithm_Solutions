package SITE02_programmers.level1;

import java.util.Arrays;

/**
 * 행렬의 덧셈
 * https://programmers.co.kr/learn/courses/30/lessons/12950
 */
public class Lesson_003_12950 {
    public static void main(String[] args) {
        int[][] arr1 = new int[2][1];
        arr1[0][0] = 1;
        arr1[1][0] = 2;
        System.out.println(Arrays.deepToString(arr1));

        int[][] arr2 = new int[2][1];
        arr2[0][0] = 3;
        arr2[1][0] = 4;

        System.out.println(Arrays.deepToString(arr2));

        int[][] result = solution(arr1, arr2);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                int result = arr1[i][j] + arr2[i][j];
                answer[i][j] = result;
            }
        }
        return answer;
    }
}
