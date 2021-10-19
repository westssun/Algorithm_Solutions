package SITE02_programmers.level1;

/**
 * 제일 작은수 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 */
public class Lesson_010_12935 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int[] answer = new int[arr.length - 1];

        int min = Integer.MAX_VALUE;

        for (int n : arr) {
            if (n < min) {
                min = n;
            }
        }

        int  num = 0;
        for (int j : arr) {
            if (j != min) {
                answer[num] = j;
                num++;
            }
        }

        return answer;
    }
}