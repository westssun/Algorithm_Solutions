package SITE01_baekjoon.level1;

import java.util.Scanner;

/**
 * 단어 뒤집기
 * https://www.acmicpc.net/problem/9093
 */
public class Problem_003_9093_3_시간초과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        while (num-- > 0) {
            String input = sc.nextLine();

            /* I, am, happy, today */
            String[] result = input.split(" ");

            for (String s : result) {
                for (int j = s.length() - 1; j > -1; j--) {
                    System.out.print(s.charAt(j));
                }
                System.out.print(" ");
            }

            System.out.println();
        }
        sc.close();
    }
}
