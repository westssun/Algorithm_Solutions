package SITE02_programmers.level1;

/**
 * 자릿수 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class Lesson_014_12931 {
    public static void main(String[] args) {
        Lesson_014_12931 lesson = new Lesson_014_12931();
        System.out.println(lesson.solution(123));
    }

    public int solution(int n) {
        int answer = 0;

        String result = String.valueOf(n);

        for (int i = 0; i < result.length(); i++) {
            int num = (int) result.charAt(i) - '0';
            answer += num;
        }

        return answer;
    }
}