package SITE02_programmers.level1;

/**
 * 문자열 다루기 기본
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 */
public class Lesson_022_12918 {
    public static void main(String[] args) {
        Lesson_022_12918 lesson = new Lesson_022_12918();

        System.out.println(lesson.solution("a234"));
    }

    public boolean solution(String s) {
        boolean answer = false;

        if (s.length() == 4 || s.length() == 6) {
            answer = true;

            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}