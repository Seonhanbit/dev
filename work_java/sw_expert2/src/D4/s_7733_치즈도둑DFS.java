package D4;

import java.util.Scanner;

public class s_7733_치즈도둑DFS {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N+2][N+2];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//1부터 100까지. 에 대해서 유기농배추짓을 할건데. 그중에 가장 큰 값을 기억해야되는데. 그값을 기억할 변수.
			int max = 1;
			for(int i = 1; i <= 100; i++) {
				//현재 1~100중의 값으로 세어진 덩어리 갯수를 저장할 변수
				int cnt = 0;
				visited = new boolean[N+2][N+2];
				//탐색하며 갯수를 센다.
				for(int r = 1; r <= N; r++) {
					for(int c = 1; c <= N; c++) {
						//i보다 큰 값이 보이면. 덩어리 발견으로 하나 세고
						if( map[r][c] > i && !visited[r][c]) {
							cnt++;
							dfs(r, c, i);
						}
					}
				}
				//최대값 갱신	
				max = Math.max(max, cnt);
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	//상태공간트리에서 노드가 갖는 상태값은 현재 좌표값과 기준값(몇이상의 값을 찾고 있는지..)
	static void dfs(int r,int c,int val) {
//		map[r][c] = 0;
		visited[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if( map[nr][nc] > val && !visited[nr][nc])
				dfs(nr, nc, val);
		}
	}
}
