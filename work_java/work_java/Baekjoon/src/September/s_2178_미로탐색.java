package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s_2178_미로탐색 {
	static int N, M;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
//		dfs(0, 0, 1);
		bfs(0, 0, 1);

	}

	static void dfs(int r, int c, int cnt) {
		if (r == N - 1 && c == M - 1) {
			System.out.println(cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if (!range(nr, nc) || visited[nr][nc] || arr[nr][nc] != 1)
				continue;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1);
			visited[nr][nc] = false;
		}
	}

	// bfs 상태공간트리에 가져갈 것 > 큐(구조체)에 담겨져야 함
	static class Node {
		int r, c, cnt;
		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static void bfs(int r, int c, int cnt) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r,c,cnt));
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			Node tmp = queue.poll(); 
			//하나 꺼내서 도착지인지 검사하기
			if(tmp.r == N-1 && tmp.c == M-1) {
				System.out.println(tmp.cnt);
				break;
			}
			for(int i=0; i<4; i++) {
				int nr = tmp.r + dr[i], nc = tmp.c + dc[i];
				if(!range(nr, nc)||arr[nr][nc]!=1||visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				queue.add(new Node(nr,nc,tmp.cnt+1));
			}
		}
	}
}
