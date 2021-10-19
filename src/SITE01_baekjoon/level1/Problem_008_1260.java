package SITE01_baekjoon.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class Problem_008_1260 {
    static int graph[][];
    static boolean[] visited;
    static int n; /* 첫째 줄의 정점 개수 */
    static int m; /* 간선 개수 */
    static int v; /* 탐색을 시작할 정점의 번호 */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int j = 0; j < n + 1; j++) {
            Arrays.fill(graph[j], 0);
        }

        Arrays.fill(visited, false);

        for (int i = 0; i < m; i++) {
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge," ");

            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        /* dfs */
        dfs(v);

        System.out.println();

        /* bfs */
        Arrays.fill(visited, false);
        bfs(v);
    }

    static void dfs(int start) {
        /* 방문 */
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i < graph[start].length; i++) {
            /* 인정행렬일 경우 */
            if (graph[start][i] == 1) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
        }
    }

    static void bfs(int start) {
        /* 방문 */
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int target = queue.poll();
            System.out.print(target + " ");

            for (int i = 1; i < graph[target].length; i++) {
                if (graph[target][i] == 1) {
                    if (!visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }

    }
}
