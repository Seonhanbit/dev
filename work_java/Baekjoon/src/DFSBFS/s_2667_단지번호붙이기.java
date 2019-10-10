package DFSBFS;

import java.io.*;
import java.util.*;

public class s_2667_단지번호붙이기 {
	static int N, cnt;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	//범위 검사하기
	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		else
			return false;
	}
	
	//
	static void dfs(int x, int y) {
		check[x][y] = true;
		arr[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!range(nx, ny))
				continue;
			if (arr[nx][ny] == 0)
				continue;
			if (check[nx][ny])
				continue;
			arr[nx][ny] = cnt;
			dfs(nx, ny);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0 && !check[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt);
		int[] res = new int[cnt + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 1; k < res.length; k++) {
					if (arr[i][j] == k) {
						res[k]++;
					}
				}
			}
		}
		Arrays.sort(res);
		for (int i = 1; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
