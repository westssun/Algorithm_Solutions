package SITE01_baekjoon.level1;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/11047
 */
public class Problem_012_11047 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String param = sc.nextLine();

        int num = Integer.parseInt(param.split(" ")[0]);
        int sum = Integer.parseInt(param.split(" ")[1]);

        Stack<Integer> stack = new Stack<Integer>();

        /* 오름차순의 경우, 제일 비싼 동전부터 체크해야햐므로 stack 사용 */
        for (int i = 0; i < num; i++) {
            Integer input = sc.nextInt();
            stack.push(input);
        }

        int count = 0; /* 동전 개수 */

        while (sum != 0) {
            int target = stack.pop();

            count += sum / target;
            sum = sum % target;
        }

        System.out.println(count);
    }
}
