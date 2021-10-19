package SITE01_baekjoon.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/17413
 */
public class Problem_007_17413 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<Character>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = sc.nextLine();

        input += " "; /* 마지막 단어도 걸리도록 추가 */

        boolean isStart = false; /* '<' '>' 사이에 존재 여부 */
        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                /* 그 전에 push 된 데이터는 pop() */
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }

                bw.write(ch);
                isStart = true; /* '<', '>' 존재여부 true */
            } else if ( ch == '>') { /* '<', '>' 사이 종료 */
                bw.write(ch);
                isStart = false; /* '<', '>' 존재여부 false */
            } else if (isStart) { /* '<', '>' 사이의 문자열은 그대로 출력 */
                bw.write(ch);
            } else { /* !isStart 일 경우 (뒤집어야할 문자열) */
                if (ch == ' ' || ch == '\n') { /* 단어 끝 */
                    while (!stack.isEmpty()) { /* 단어가 들어가있을 stack 을 pop() */
                        bw.write(stack.pop());
                    }

                    bw.write(ch); // 공백
                } else { /* push */
                    stack.push(ch);
                }
            }
        }

        bw.flush();
    }
}
