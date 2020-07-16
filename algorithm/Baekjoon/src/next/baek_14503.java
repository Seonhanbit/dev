package new_;

import java.io.*;
import java.util.*;

// 로봇청소기
public class baek_14503 {
	static int N, M, r, c, d, val;
	static int[][] arr;
	static boolean[][] ck;
	// 0 -> 북, 1 동, 2 남, 3 서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		val = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm();
		bw.write(String.valueOf(val));
		bw.flush();
		bw.close();
	}

	static void perm() {
		// 1. 현재 위치를 청소한다.
		if (arr[r][c] == 0) {
			arr[r][c] = 1;
			val++;
		}
		while (true) {
			if (d == 0) {
				int k = 3;
				int b = 2;
				
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nx = r + dx[i], ny = c + dy[i];
					if (!range(nx, ny)) {
						cnt++;
						continue;
					}
					if (arr[nx][ny] == 1)
						cnt++;
				}
				if (cnt == 4) {
					if (!range(r + dx[b], c + dy[b]))
						break;
					else {
						r = r + dx[b];
						c = c + dy[b];
						continue;
					}
				}
				
				// 2. 왼쪽 청소해야하면, 그 방향으로 회전한 다음 한칸 전진
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 0) {
					r = r + dx[k];
					c = c + dy[k];
					arr[r][c] = 1;
					val++;
					d = k;
					continue;
				}
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 1) {
					d = k;
					continue;
				}
			} else if (d == 1) {
				int k = 0;
				int b = 3;
				
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nx = r + dx[i], ny = c + dy[i];
					if (!range(nx, ny)) {
						cnt++;
						continue;
					}
					if (arr[nx][ny] == 1)
						cnt++;
				}
				if (cnt == 4) {
					if (!range(r + dx[b], c + dy[b]))
						break;
					else {
						r = r + dx[b];
						c = c + dy[b];
						continue;
					}
				}
				
				// 2. 왼쪽 청소해야하면, 그 방향으로 회전한 다음 한칸 전진
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 0) {
					r = r + dx[k];
					c = c + dy[k];
					arr[r][c] = 1;
					val++;
					d = k;
					continue;
				}
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 1) {
					d = k;
					continue;
				}
				
			} else if (d == 2) {
				int k = 1;
				int b = 0;
				
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nx = r + dx[i], ny = c + dy[i];
					if (!range(nx, ny)) {
						cnt++;
						continue;
					}
					if (arr[nx][ny] == 1)
						cnt++;
				}
				if (cnt == 4) {
					if (!range(r + dx[b], c + dy[b]))
						break;
					else {
						r = r + dx[b];
						c = c + dy[b];
						continue;
					}
				}
				
				// 2. 왼쪽 청소해야하면, 그 방향으로 회전한 다음 한칸 전진
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 0) {
					r = r + dx[k];
					c = c + dy[k];
					arr[r][c] = 1;
					val++;
					d = k;
					continue;
				}
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 1) {
					d = k;
					continue;
				}

			} else if (d == 3) {
				
				int k = 2;
				int b = 1;
				
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nx = r + dx[i], ny = c + dy[i];
					if (!range(nx, ny)) {
						cnt++;
						continue;
					}
					if (arr[nx][ny] == 1)
						cnt++;
				}
				if (cnt == 4) {
					if (!range(r + dx[b], c + dy[b]))
						break;
					else {
						r = r + dx[b];
						c = c + dy[b];
						continue;
					}
				}

				// 2. 왼쪽 청소해야하면, 그 방향으로 회전한 다음 한칸 전진
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 0) {
					r = r + dx[k];
					c = c + dy[k];
					arr[r][c] = 1;
					val++;
					d = k;
					continue;
				}
				if (range(r + dx[k], c + dy[k]) && arr[r + dx[k]][c + dy[k]] == 1) {
					d = k;
					continue;
				}
			}
		}
	}

}
