package SITE02_programmers.level1;

/**
 * 문자열 내 p와 y의 개수
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class Lesson_024_12916 {
    boolean solution(String s) {
        boolean answer = false;

        // 소문자변환
        s = s.toLowerCase();

        // method call
        answer = getResult(s);

        return answer;
    }

    boolean getResult(String inputString) {
        char p = 'p';
        char y = 'y';

        long pCount = inputString.chars()
                .filter(ch -> p == ch)
                .count();

        long yCount = inputString.chars()
                .filter(ch -> y == ch)
                .count();

        return pCount == yCount;
    }
}