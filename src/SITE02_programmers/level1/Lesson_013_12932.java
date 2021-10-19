package SITE02_programmers.level1;

import java.util.Arrays;

/**
 * 정수 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */
public class Lesson_013_12932 {
    public static void main(String[] args) {
        Lesson_013_12932 lesson = new Lesson_013_12932();
        System.out.println(Arrays.toString(lesson.solution(12345)));
    }

    public int[] solution(long n) {

        /* long n 을 String 타입 배열 변환 */
        String param = String.valueOf(n);
        String[] arr = param.split("");

        int[] answer = new int[arr.length];

        /* int 타입 배열 변환 */
        int num = 0;
        for (int i = arr.length - 1; i > -1; i--) {
            answer[num] = Integer.parseInt(arr[i]);
            num++;
        }

        return answer;
    }

    /**
     * 해당 문제는 정렬문제가 아니고, 뒤집기 문제라 아래는 정렬한 메서드 주석처리
     * @param n
     * @return
     */
    public int[] test(long n) {

        /* long n 을 String 타입 배열 변환 */
        String param = String.valueOf(n);
        String[] arr = param.split("");

        int[] answer = new int[arr.length];

        /* int 타입 배열 변환 */
        for (int i = 0; i < arr.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }

        /* 삽입정렬 사용 */
        for (int i = 1; i < answer.length; i++) {
            for (int j = i; j > 0; j--) {
                if (answer[j] > answer[j - 1]) {
                    int temp = answer[j];
                    answer[j] = answer[j - 1];
                    answer[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}