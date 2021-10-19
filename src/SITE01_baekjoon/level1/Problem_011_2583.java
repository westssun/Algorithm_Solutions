package SITE01_baekjoon.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2583
 */
public class Problem_011_2583 {
    static int[][] graph;
    static int N;
    static int M;
    static int K;
    static int count = 0;
    static StringBuilder result = new StringBuilder();
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        graph = new int[M][N];
        visited = new boolean[M][N];

        /* 인접행렬 생성 */
        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            /* 입력 값에 따라 직사각형은 1로 셋팅 */
            for (int a = y1; a < y2; a++) {
                for (int b = x1; b < x2; b++) {
                    graph[a][b] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) { /* 방문하지 않았을 경우 */
                    if (graph[i][j] == 0) { /* 색칠되지 않았을 경우 인접한 색칠되지 않은 영역을 찾는다 */
                        count = 0;
                        dfs(i, j);

                        /** 한번 dfs 함수 호출로 증가된 count 가 분리되는 영역의 카운트 */
                        list.add(count); /* 리스트에 결과 count 요소 add */
                    }
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (Integer value : list) {
            System.out.print(value + " ");
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (graph[nx][ny] == 0) {
                    if (!visited[nx][ny]) {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }
}
