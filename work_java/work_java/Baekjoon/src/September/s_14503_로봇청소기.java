package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_14503_로봇청소기 {
	static int N, M;
	static int[][] arr;
	static int res = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

//	static class robot {
//		int x;
//		int y;
//		int dic;
//
//		robot(int x, int y, int dic) {
//			this.x = x;
//			this.y = y;
//			this.dic = dic;
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (arr[r][c] == 0) {
				res++;
				arr[r][c] = 3;
			}
			// 네방향 모두 청소 되었을때 한칸 후진
			if (arr[r - 1][c] != 0 && arr[r + 1][c] != 0 && arr[r][c - 1] != 0 && arr[r][c + 1] != 0) {
				if (arr[r- dx[d]][c - dy[d]] != 1) {
					r -= dx[d];
					c -= dy[d];
				} else
					break;
			} else {
				d = (d+3)%4;
				if (arr[r+dx[d]][c+dy[d]] == 0) {
					r += dx[d];
					c += dy[d];
				}
			}
		}
		System.out.println(res);
	}

}
