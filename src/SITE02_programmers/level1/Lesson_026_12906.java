package SITE02_programmers.level1;

import java.util.Arrays;

/**
 * 같은 숫자는 싫어
 * https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Lesson_026_12906 {
    public static void main(String[] args) {
        Lesson_026_12906 lesson = new Lesson_026_12906();

        int[] arr = new int[5];
        arr[0] = 4;
        arr[1] = 4;
        arr[2] = 3;
        arr[3] = 3;
        arr[4] = 3;

        System.out.println(Arrays.toString(lesson.solution(arr)));
    }

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];

        int size = 0; /* 마지막 결과에 담을 배열 size */
        int answerLastVal = 0; /* answer 배열의 마지막 요소 업데이트 */

        for (int i = 0; i < arr.length; i++) {
            // 처음 시작
            if (i == 0) {
                answer[i] = arr[i];
                answerLastVal = answer[i]; // 마지막 요소 update
                size++;
            }  else {
                // 두번째 부터는 이전의 요소와 확인
                if (answerLastVal != arr[i]) {
                    answer[i] = arr[i];
                    answerLastVal = answer[i]; // 마지막 요소 update
                    size++;
                } else {
                    /* -1은 배열에 있을 수 없으므로 지우기 위해 -1로 지정 */
                    answer[i] = -1;
                }
            }
        }

        // 요소 -1 제거
        int[] result = new int[size];
        int index = 0;
        for (int j : answer) {
            if (j != -1) {
                result[index] = j;
                index++;
            }
        }

        return result;
    }
}