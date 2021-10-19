package SITE02_programmers.level2;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 */

public class Lesson_041_12909 {
    public static void main(String[] args) {
        Lesson_041_12909 lesson = new Lesson_041_12909();

        System.out.println(lesson.solution("()()"));
    }

    boolean solution(String s) {
        boolean answer = false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            /* '(' 일때 stack push */
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                /* ')' 일때 stack 에서 짝 '(' 을 꺼낸다 */
                if (!stack.isEmpty()) { /* 비어져있지 않을때 */
                    stack.pop(); /* '(' 1개 pop */
                    answer = true;
                } else { /* stack 이 비어져있다면 닫히지 않는다는 의미 */
                    answer = false;
                    break;
                }
            }
        }

        /* stack 이 비어져있지 않다면 '('가 남아있다는 의미 */
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}