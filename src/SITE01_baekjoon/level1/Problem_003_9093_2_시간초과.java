package SITE01_baekjoon.level1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 단어 뒤집기
 * https://www.acmicpc.net/problem/9093
 */
public class Problem_003_9093_2_시간초과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        Stack<Character> stack = new Stack<Character>();
        sc.nextLine();

        while(num-- > 0) {
            String input = sc.nextLine();
            input += " "; /* 마지막 단어도 걸리도록 추가 */

            for (int i = 0; i < input.length(); i++) {
                /* ' ' 만날시 stack 에 단어 push 완료 */
                if (input.charAt(i) == ' ') {
                    /* stack 이 비어져있다는건, 하나의 단어를 모두 꺼냈다는 것 */
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }

                    System.out.print(" ");
                } else { /* stack 에 단어 단위로 한 자씩 push */
                    stack.push(input.charAt(i));
                }
            }

            System.out.println();
        }
        sc.close();
    }
}
