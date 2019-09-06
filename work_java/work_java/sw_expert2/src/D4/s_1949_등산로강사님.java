package D4;

import java.util.Scanner;

public class s_1949_등산로강사님 {
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			//입력을 받으면서. 최대값을 기억하고 있다가. 그 위치에서 탐색을 시작하자.
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}
			MAX = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if( max == map[i][j]) {
						dfs(i, j, map[i][j], false, 1);
					}
				}
			}
			System.out.println("#" + tc + " " + MAX);
		}
	}
	static int MAX = 0;
	//상태노드의 정보는... 좌표(행.열). 그곳의 높이(이걸 들고다니면 까고 갔을때 계산이 쉬움). 땅까기 사용여부. 지금까지의 길이.
	static void dfs(int r,int c,int hight, boolean isUsed, int cnt) {
		visited[r][c] = true;
		MAX = Math.max(MAX, cnt);
		for(int i = 0 ; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if( !visited[nr][nc] ) {
				if( map[nr][nc] < hight )
					dfs(nr, nc, map[nr][nc], isUsed, cnt+1);
				else if( !isUsed && map[nr][nc] - K < hight ) {
					dfs(nr, nc, hight-1, true, cnt + 1);
				}
			}
		}
		visited[r][c] = false;
	}
}
