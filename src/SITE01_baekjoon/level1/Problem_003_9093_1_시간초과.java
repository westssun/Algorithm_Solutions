package SITE01_baekjoon.level1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 단어 뒤집기
 * https://www.acmicpc.net/problem/9093
 */
public class Problem_003_9093_1_시간초과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        Stack<Character> stack = new Stack<Character>();
        sc.nextLine();

        while (num-- > 0) {
            String input = sc.nextLine();

            /* I, am, happy, today */
            String[] result = input.split(" ");

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length(); j++) {
                    stack.push(result[i].charAt(j));
                }

                for (int y = 0; y < result[i].length(); y++) {
                    System.out.print(stack.pop());
                }

                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
