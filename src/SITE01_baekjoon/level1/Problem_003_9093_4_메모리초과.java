package SITE01_baekjoon.level1;

import java.util.Scanner;
import java.util.Stack;

// 9093번 단어 뒤집기
public class Problem_003_9093_4_메모리초과 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= size; i++) {
            // 문장 입력
            String input = sc.nextLine();

            // 단어를 담을 스택
            Stack<Character> stack = new Stack<Character>();

            // 단어를 스택에 담기 시작
            for (char temp : input.toCharArray()) {
                // 띄어쓰기가 있을 경우 스택를 비워 출력(선입후출)
                if (temp == ' ') {
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(" ");
                } else {
                    stack.push(temp);
                }
            }

            // 마지막 스택까지 비워서 역순으로 출력(선입후출)
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }

            System.out.println();
        }

        sc.close();
    }
}