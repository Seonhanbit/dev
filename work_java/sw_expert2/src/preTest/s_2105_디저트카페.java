package preTest;

import java.io.*;
import java.util.*;

public class s_2105_디저트카페 {
	static int T, N, sr, sc, res;
	static int[][] arr;
	static boolean[] visited;
	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { -1, 1, 1, -1 };

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			res = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 2; i < N; i++) {
				for (int j = 1; j < N; j++) {
					//디저트 숫자는 101개
					visited = new boolean[101];
					sr = i;
					sc = j;
					dfs(i, j, 0, 1);
				}
			}
			if (res == Integer.MIN_VALUE)
				res = -1;

			bw.append("#").append(String.valueOf(tc)).append(" ").append(res + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void dfs(int x, int y, int d, int cnt) {
		if (d == 3 && x == sr && y == sc && cnt > 3) {
			System.out.println("나얌 " + x + "," + y + " : " + (cnt - 1));
			if (cnt - 1 > res)
				res = cnt - 1;
		}

		if (!range(x, y))
			return;
		if (d == 4)
			return;
		if (visited[arr[x][y]])
			return;

		//현재 상태에서 방향을 바꾼 것을 선택하던가 계속 같은 방향으로 가던가!!!!
		//빠져나올때는 false 체크해주기(안먹은 디저트 값은 다시 체크를 풀어줘야해)
		//true 상태로 가서 방향을 바꾸고, 안 바꾸고
		System.out.println("시작!!!!!!!!!"+x + "," + y + " : " + cnt);
		visited[arr[x][y]] = true;
		dfs(x + dx[d], y + dy[d], d + 1, cnt + 1);
		System.out.println("======"+x + "," + y + " : " + cnt);
		dfs(x + dx[d], y + dy[d], d, cnt + 1);
		visited[arr[x][y]] = false;
	}

}
