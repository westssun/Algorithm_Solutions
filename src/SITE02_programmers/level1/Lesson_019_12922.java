package SITE02_programmers.level1;

/**
 * 수박수박수박수박수박수?
 * https://programmers.co.kr/learn/courses/30/lessons/12922
 */
public class Lesson_019_12922 {
    public static void main(String[] args) {
        Lesson_019_12922 lesson = new Lesson_019_12922();
        System.out.println(lesson.solution(3));
    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer.append("수");
            } else {
                answer.append("박");
            }
        }

        return answer.toString();
    }
}