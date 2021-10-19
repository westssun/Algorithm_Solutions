package SITE02_programmers.level1;

/**
 * 문자열을 정수로 바꾸기
 * https://programmers.co.kr/learn/courses/30/lessons/12925
 */
public class Lesson_018_12925 {
    public static void main(String[] args) {
        Lesson_018_12925 lesson = new Lesson_018_12925();
        System.out.println(lesson.solution("1234"));
    }

    public int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s);

        return answer;
    }
}