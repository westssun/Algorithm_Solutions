package SITE02_programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12936
 */

public class Lesson_055_12936 {
    static int[] arr;
    static boolean[] visited;
    static int[] answer;
    static List<int[]> output = new ArrayList<>();
    static int arrSize;

    public static void main(String[] args) {
        Lesson_055_12936 lesson = new Lesson_055_12936();

        System.out.println(Arrays.toString(lesson.solution(3, 5)));
    }

    public int[] solution(int n, long k) {
        /* data setting */
        arr = new int[n];
        visited = new boolean[n];
        answer = new int[n];
        arrSize = n;

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        permutation(0);


        return output.get(Integer.parseInt(String.valueOf(k - 1)));
    }

    /**
     * 순열 코드
     * @param depth
     */
    public void permutation(int depth) {
        if (depth == arrSize) { // 3개 모두 뽑았을 경우
            System.out.println("answer: " + Arrays.toString(answer));

            int[] dupArr = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                dupArr[i] = answer[i];
            }

            output.add(dupArr);

            return;
        }

        for (int i = 0; i < arrSize; i++) {
            if (!visited[i]) {
                visited[i] = true;

                answer[depth] = arr[i];
                permutation(depth + 1);

                visited[i] = false;
            }
        }

    }
}