package SITE01_baekjoon.level1;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10026
 */
public class Problem_010_10026 {
    static char[][] graph;
    static int N;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        graph = new char[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        /* 인접행렬 생성 */
        for (int i = 0; i < N; i++) {
            String s = sc.next();

            for (int j = 0; j < N; j++) {
                graph[i + 1][j + 1] = s.charAt(j);
            }
        }

        String result = "";

        /* 적록색약이 아닌 사람의 경우 */
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        result = count + " ";

        /* 적록색약인 사람의 경우 : 빨강, 초록이 같은 색상 */
        /* 초록을 빨강으로 변경해준다. G -> R */
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        count = 0; // 초기화
        visited = new boolean[N + 1][N + 1]; // 초기화

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        result += count;

        System.out.println(result);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > 0 && ny > 0 && nx < N + 1 && ny < N + 1) {
                /* 같은 색은 같은 구역으로 본다, count 가 증가되지 않는다 */
                if (graph[x][y] == graph[nx][ny]) {
                    if (!visited[nx][ny]) {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }
}
