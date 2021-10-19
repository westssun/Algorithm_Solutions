package SITE02_programmers.level1;

/**
 * 가운데 글자 가져오기
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class Lesson_027_12903 {
    public static void main(String[] args) {
        Lesson_027_12903 lesson = new Lesson_027_12903();

        System.out.println(lesson.solution("qwer"));
    }

    public String solution(String s) {
        String answer = "";

        int n = 0;

        if (s.length() % 2 == 0) {
            n = s.length() / 2;
            answer += s.charAt(n - 1);
            answer += s.charAt(n);
        } else {
            n = s.length() / 2;
            answer += s.charAt(n);
        }

        return answer;
    }
}