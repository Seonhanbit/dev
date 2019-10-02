package October;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s_2573_빙산 {
	static int N, M;
	static int res = 0;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean ck;

	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}
	
	static class XY{
		int x;
		int y;
		XY(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

	static void dfs(int x, int y) {

		for (int i = x; i < N; i++) {
			for (int j = y; j < N; j++) {
				if (arr[i][j] != 0)
					bfs(i, j);
			}
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!range(nx, ny))
				continue;
			if (arr[nx][nx] == 0)
				continue;
			arr[nx][ny] -= 1;
			res++;
			dfs(nx, ny);
		}
	}

	static void bfs(int x, int y) {
		Queue<XY> queue = new LinkedList<>();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer((br.readLine()));
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int x = 0, y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer((br.readLine()));
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					x = i;
					y = j;
				}
			}
		}
		dfs(x, y);
		System.out.println(res);
	}

}


/*static class Huu {
	int r, c, k;
​
	public Huu(int r, int c, int k) {
		super();
		this.r = r;
		this.c = c;
		this.k = k;
	}
}
​
static int[] dr = { -1, 1, 0, 0 };
static int[] dc = { 0, 0, -1, 1 };
​
static void bfs(int r, int c) {
	q.add(new Huu(r, c, 0));
	visited[r][c] = true;
​
	while (!q.isEmpty()) {
		Huu now = q.poll();
		for (int d = 0; d < 4; d++) {
			int nr = now.r + dr[d], nc = now.c + dc[d];
​
			if (map[nr][nc] == 0)
				continue;
			if (visited[nr][nc])
				continue;
​
			q.add(new Huu(nr, nc, 0));
			visited[nr][nc] = true;
		}
	}
}
​
static Queue<Huu> q = new LinkedList<>();
static int[][] map;
static boolean[][] visited;
​
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer stk = new StringTokenizer(br.readLine());
	int R = Integer.parseInt(stk.nextToken());
	int C = Integer.parseInt(stk.nextToken());
	map = new int[R][C];
	ArrayList<Huu> list = new ArrayList<>();
	for (int r = 0; r < R; r++) {
		stk = new StringTokenizer(br.readLine());
		for (int c = 0; c < C; c++) {
			map[r][c] = Integer.parseInt(stk.nextToken());
			if (map[r][c] > 0)
				list.add(new Huu(r, c, 0));
		}
	}
​
	for (int loop = 0; list.size() > 0; loop++) {
​
		visited = new boolean[R][C];
		int re = 0;
		for (int r = 1; r < R - 1; r++) {
			for (int c = 1; c < C - 1; c++) {
				if (map[r][c] != 0 && visited[r][c] == false) {
					bfs(r, c);
					re++;
				}
			}
		}
​
		if (re >= 2) {
			System.out.println(loop);
			return;
		}
​
		for (int i = 0; i < list.size(); i++) {
			Huu p = list.get(i);
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d], nc = p.c + dc[d];
				if (map[nr][nc] == 0)
					p.k++;
			}
		}
​
		ArrayList<Integer> del_list = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Huu p = list.get(i);
			map[p.r][p.c] -= p.k;
			if (map[p.r][p.c] <= 0) {
				map[p.r][p.c] = 0;
				del_list.add(i);
			}
			p.k = 0;
		}
​
		Collections.sort(del_list);
		for (int i = del_list.size() - 1; i >= 0; i--) {
			int del_idx = del_list.get(i);
			list.remove(del_idx);
		}
​
//		for (int r = 0; r < R; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
//		System.out.println();
	}
	System.out.println(0);
}
}
*/