package SITE02_programmers.level2;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 */

public class Lesson_049_12973 {
    public static void main(String[] args) {
        Lesson_049_12973 lesson = new Lesson_049_12973();

        int[] a = new int[]{1,2,3};
        System.out.println(lesson.solution("baabaa"));
    }

    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);

            if (!stack.isEmpty() && target == stack.peek()) {
                stack.pop();
            } else {
                stack.push(target);
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}