package SITE01_baekjoon.level2;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1182
 */
public class Problem_014_1182 {
    //static을 이용해 공유 변수를 만든다.
    static int N;
    static int S;
    static int[] arr;
    static boolean[] visited; //스킵 판별
    static int cnt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String param = sc.nextLine();

        N = Integer.parseInt(param.split(" ")[0]);
        S = Integer.parseInt(param.split(" ")[1]);
        arr = new int[N];
        visited = new boolean[N];

        /* 집합 S */
        String S = sc.nextLine();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(S.split(" ")[i]);
        }

        dfs(0); /* dfs 호출 */
        System.out.println(cnt);
    }

    static void dfs(int value) {

        int sum = 0;
        boolean isPassed = false; /* S가 0일 경우 sum 되지 않을때 count 방지 */

        for (int i = 0; i < N; i++) {
            if (visited[i]) { /* true 일 경우 */
                sum += arr[i];
                isPassed = true;
            }
        }

        /* S 와 합이 동일할 경우 cnt++ 실행 */
        if (isPassed && sum == S) {
            cnt++;
        }

        /* 재귀함수 */
        for (int j = value; j < N; j++) {
            visited[j] = true;
            dfs(j + 1);

            visited[j] = false;
        }
    }
}
