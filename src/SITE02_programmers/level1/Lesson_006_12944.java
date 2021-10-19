package SITE02_programmers.level1;

/**
 * 평균 구하기
 * https://programmers.co.kr/learn/courses/30/lessons/12944
 */
public class Lesson_006_12944 {
    public double solution(int[] arr) {
        double answer = 0;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        answer = (double) sum / arr.length;
        return answer;
    }
}