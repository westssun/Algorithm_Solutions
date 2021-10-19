package SITE02_programmers.level1;

/**
 * 하샤드 수
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */
public class Lesson_005_12947 {
    public boolean solution(int x) {
        boolean answer = true;

        String result = String.valueOf(x);

        int sum = 0;
        for (int i = 0; i < result.length(); i++) {
            char a = result.charAt(i);

            /* char to int */
            sum += Character.getNumericValue(a);
        }

        if (x % sum != 0) {
            answer = false;
        }

        return answer;
    }
}