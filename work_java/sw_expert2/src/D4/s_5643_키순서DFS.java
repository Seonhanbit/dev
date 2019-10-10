package D4;

import java.util.Scanner;

public class s_5643_키순서DFS {
	static int N;
    static int[][] adj;
    static int[] cntArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();//사람의 수
            adj = new int[N+1][N+1];
            int M = sc.nextInt();
            for(int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a][b] = 1;
            }
            //탐색을 하며, 새로운 노드를 만날때마다, 최초 출발지의 카운트값을 1씩 늘리자.
            cntArr = new int[N+1];
            for(int i = 1; i <= N; i++) {
                //각 출발별로 새로운 방문체크와, 현재 방문 i번째, 0은 순방향, 1은 역방향, 최초 출발지 i
                dfs(new boolean[N+1], i, 0, i);
                dfs(new boolean[N+1], i, 1, i);
            }
//          System.out.println(Arrays.toString(cntArr));
            int cnt = 0;
            for(int i = 1; i <= N; i++) {
                if( cntArr[i] == N-1)
                    cnt++;
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
    static void dfs(boolean[] visited, int cur, int dir, int start) {
        if(dir == 0) {
            for(int i = 1; i <= N; i++) {
                if( adj[cur][i] == 1 && !visited[i] ) {
                    visited[i] = true;
                    cntArr[start]++;
                    dfs(visited, i, dir, start);
                }
            }
        }
        else {
            for(int i = 1; i <= N; i++) {
                if( adj[i][cur] == 1 && !visited[i] ) {
                    visited[i] = true;
                    cntArr[start]++;
                    dfs(visited, i, dir, start);
                }
            }
        }
    }
}
