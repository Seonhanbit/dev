package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s_1949_등산로조성 {
	static int N;
	static int K;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int res = 0;

	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			int max = Integer.MIN_VALUE;
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > max)
						max = arr[i][j];
				}
			}


			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == max) {
						for(int k=0; k<N; k++) {
							for(int l=0; l<N; l++) {
								for (int go = 0; go <= K; go++) {
									arr[k][l] -= go;
									dfs(i, j, 1);
									arr[k][l] += go;
								}
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + res);
		}
	}

	static void dfs(int x, int y, int cnt) {
		if (cnt > res)
			res = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (!range(nx, ny) || arr[x][y] <= arr[nx][ny])
				continue;
			dfs(nx, ny, cnt + 1);
		}
	}

}
