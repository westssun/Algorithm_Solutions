package SITE02_programmers.level2;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */

public class Lesson_044_42883 {
    public static void main(String[] args) {
        Lesson_044_42883 lesson = new Lesson_044_42883();

        System.out.println(lesson.solution("4177252841", 4));
    }

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char target = number.charAt(i);

            /**
             * stack 에는 순서대로 큰 수만 들어간다.
             */
            while (!stack.isEmpty() && k > 0){
                char peek = stack.peek();

                if (peek < target) { // 스택팝보다 큰 수를 넣어야함
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }

            stack.push(target);
        }

        while (!stack.isEmpty() && k > 0) { // 숫자가 끝났는데도 k가 남았다면 그만큼 팝 (같은숫자의 경우 77777)
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) { //최종 값 생성
            // answer = stack.pop() + answer;
            answer.insert(0, stack.pop());
        }

        return answer.toString();
    }
}