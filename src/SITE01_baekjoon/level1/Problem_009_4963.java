package SITE01_baekjoon.level1;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/4963
 */
public class Problem_009_4963 {
    static int W; /* 지도의 너비 */
    static int H; /* 지도의 높이 */
    static int[][] graph;

    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

    static boolean[][] visited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            W = sc.nextInt();
            H = sc.nextInt();

            if (W == 0 && H == 0) {
                break;
            }

            graph = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];

            for (int i = 1; i < H + 1; i++) {
                for (int j = 1; j < W + 1; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            count = 0;

            for (int i = 1; i < H + 1; i++) {
                for (int j = 1; j < W + 1; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        search(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void search(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > 0 & ny > 0 && nx <= H && ny <= W) {
                if (graph[nx][ny] == 1) {
                    if (!visited[nx][ny]) {
                        search(nx, ny);
                    }
                }
            }
        }
    }
}
