package march;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class s10026_적록색약 {
	static int N;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Collection<String> list = new ArrayList<>();
		
		arr = new char[N][N];
		visited = new boolean[N][N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		int ncnt = 0;
		visited = new boolean[N][N];
		// rgb 배열에서 r -> g
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G')
					arr[i][j] = 'R';
			}
		}

		// 색약 : 모든 좌표를 돌면서, 방문하지 않은 좌표는 dfs 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					ncnt++;
					dfs(i, j);
				}
			}
		}
		
		bw.append(cnt + " " + ncnt);
		bw.flush();
		bw.close();
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i], nc = c + dy[i];
			if (!range(nr, nc))
				continue;
			if (visited[nr][nc])
				continue;
			if (arr[nr][nc] == arr[r][c]) {
				dfs(nr, nc);
			}
		}
	}
}
