package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s_1861_정사각형방 {
	static int N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr = null;
	static int cnt = 0;
	static int value = 0;

	public static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		else
			return false;
	}

	public static class XY {
		int x;
		int y;

		XY(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			cnt = Integer.MIN_VALUE;
			value = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// Ans에 말갖지도 않은 답 넣어놓기
			ans = new Ans(9864684, 0);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
					// dfs(i,j,1,arr[i][j]);
				}
			}

			System.out.println("#" + tc + " " + value + " " + cnt);
		}
	}

	static Ans ans;

	// x,y좌표, 카운트, 출발한 값
	public static void dfs(int x, int y, int cnt, int start) {
		// 기저파트가 없음 - 갈 곳 없으면 끝나버림
		Ans tmp = new Ans(start, cnt);
		if (ans.compareTo(tmp) > 0) {
			ans = tmp;
		}
		//위와 같은 말
//		if (tmp.cnt > ans.cnt) {
//			ans = tmp;
//		} else if (tmp.cnt == ans.cnt) {
//			if (tmp.start < ans.start)
//				ans = tmp;
//		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (arr[nx][ny] == arr[x][y] + 1) {
				dfs(nx, ny, cnt + 1, start);
			}
		}
	}

	// 정렬 조건
	static class Ans implements Comparable<Ans> {
		int start;
		int cnt;

		Ans(int s, int c) {
			start = s;
			cnt = c;
		}

		//단지 비교하는 함수 
		@Override
		public int compareTo(Ans o) {
			if (this.cnt == o.cnt)
				return this.start - o.start;
			return o.cnt - this.cnt;
		}

		public String toString() {
			return this.start + " " + this.cnt;
		}
	}

	public static void bfs(int x, int y) {
		Queue<XY> queue = new LinkedList<XY>();
		queue.add(new XY(x, y));
//		ck_arr[x][y] = true;	
		int ncnt = 0;
		int nvalue = arr[x][y];
		while (!queue.isEmpty()) {
			XY temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp.x + dx[k], ny = temp.y + dy[k];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] != (arr[temp.x][temp.y] + 1))
					continue;
//				if(ck_arr[nx][ny])
//					continue;
				queue.add(new XY(nx, ny));
//				ck_arr[nx][ny] = true;
			}
			ncnt++;
		}
		if (ncnt > cnt) {
			cnt = ncnt;
			value = arr[x][y];
		} else if (ncnt == cnt) {
			if (value > arr[x][y])
				value = arr[x][y];
		}
	}

}
