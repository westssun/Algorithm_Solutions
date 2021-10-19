package SITE01_baekjoon.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 */
public class Problem_005_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        int lastValue = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (lastValue < value) {
                for (int j = lastValue + 1; j < value + 1; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }

                lastValue = value;
            } else {
                if (stack.peek() != value) {
                    System.out.println("NO");
                    return;
                }
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
