package SITE01_baekjoon.level2;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/6603
 */
public class Problem_013_6603 {
    //static을 이용해 공유 변수를 만든다.
    static int k;
    static int[] arr;
    static boolean[] visited; //스킵 판별

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String param = "";

        while (true) {
            param = sc.nextLine();

            if (param.equals("0")) {
                break;
            }

            k = Integer.parseInt(param.split(" ")[0]);

            arr = new int[k];
            visited = new boolean[k];

            /* 집합 S */
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(param.split(" ")[i + 1]);
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int line,int count) {

        if (count == 6) { /* 6개가 만들어졌을 경우 */
            for (int i = 0; i < k; i++) {
                if (visited[i]) { /* true 일 경우 */
                    System.out.print(arr[i] + " "); /* 출력 */
                }
            }

            System.out.println("");
        }

        for (int j = line; j < k; j++) {
            visited[j] = true; /* count 가 6일될때 true 인 숫자를 출력 */
            dfs(j + 1, count + 1);

            visited[j] = false;
        }
    }
}
