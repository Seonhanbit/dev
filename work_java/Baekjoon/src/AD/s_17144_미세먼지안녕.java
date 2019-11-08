package AD;

import java.io.*;
import java.util.*;

//미세먼지 안녕
public class s_17144_미세먼지안녕 {
	static int R, C, T, res;
	static int[][] arr;
	static XY[] air;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		air = new XY[2];
		res = 0;
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1)
					air[idx++] = new XY(i, j);
			}
		}
		for (int k = 1; k <= T; k++) {
			int[][] narr = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] != 0 && arr[i][j] != -1) {
						int cnt = 0;
						int val = arr[i][j] / 5;
						if (val == 0)
							continue;
						for (int l = 0; l < 4; l++) {
							int nx = i + dx[l], ny = j + dy[l];
							if (!range(nx, ny))
								continue;
							if (arr[nx][ny] == -1)
								continue;
							narr[nx][ny] += val;
							cnt++;
						}
						arr[i][j] -= (val * cnt);
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					arr[i][j] += narr[i][j];
				}
			}
			// 공기청정기 시작
			//System.out.println();
			//print(arr);
			//System.out.println("=========================================");
			Refresh();
			//System.out.println("=========================================");
			//print(arr);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != -1)
					res += arr[i][j];
			}
		}
		bw.append(res + "\n");
		bw.flush();
		bw.close();
	}

	public static void Refresh() {
		// 공청기1
		// 아래
		for (int i = air[0].x - 1; i > 0; i--) {
			arr[i][0] = arr[i - 1][0];
		}
		// 왼쪽
		for (int j = 0; j < C - 1; j++) {
			arr[0][j] = arr[0][j + 1];
		}
		// 위쪽
		for (int i = 0; i < air[0].x; i++) {
			arr[i][C - 1] = arr[i + 1][C - 1];
		}
		// 오른쪽
		for (int j = C - 1; j > 0; j--) {
			arr[air[0].x][j] = arr[air[0].x][j - 1];
		}
		arr[air[0].x][1] = 0;

		// 공청기2
		// 위
		for (int i = air[1].x + 1; i < R - 1; i++) {
			arr[i][0] = arr[i + 1][0];
		}

		// 왼쪽
		for (int j = 0; j < C - 1; j++) {
			arr[R - 1][j] = arr[R - 1][j + 1];
		}
		// 아래
		for (int i = R - 1; i > air[1].x; i--) {
			arr[i][C - 1] = arr[i - 1][C - 1];
		}
		// 오른쪽
		for (int j = C - 1; j > 0; j--) {
			arr[air[1].x][j] = arr[air[1].x][j - 1];
		}
		arr[air[1].x][1] = 0;

	}

	public static void print(int[][] map) {
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
	}
}
