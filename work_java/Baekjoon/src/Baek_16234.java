import java.io.*;
import java.util.*;

public class Baek_16234 {
	static int N, L, R, sum, cnt, res;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<XY> queue;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<XY> list;

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		list = new ArrayList<>();
		res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			boolean flag = false;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					list.clear();
					sum = 0;
					cnt = 0;
					boolean ck = false;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k], ny = j + dy[k];
						if (!range(nx, ny))
							continue;
						if (visited[i][j])
							continue;
						if (L <= Math.abs(arr[i][j] - arr[nx][ny]) && R >= Math.abs(arr[i][j] - arr[nx][ny])) {
							visited[i][j] = true;
							sum += arr[i][j];
							cnt++;
							queue.add(new XY(i, j));
							ck = true;
						}
					}
					if (ck)
						bfs(i, j);
					if (list.size()>1) {
						check();
						flag = true;
					}
				}
			}
			if (flag)
				res++;
			else
				break;
		}

		bw.append(res + "\n");
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y) {
		list.add(new XY(x, y));
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (L <= Math.abs(arr[tmp.x][tmp.y] - arr[nx][ny]) && R >= Math.abs(arr[tmp.x][tmp.y] - arr[nx][ny])) {
					visited[nx][ny] = true;
					sum += arr[nx][ny];
					cnt++;
					queue.add(new XY(nx, ny));
					list.add(new XY(nx, ny));
				}
			}
		}
	}

	static void check() {
		int su = sum / cnt;
		for (int i = 0; i < list.size(); i++) {
			XY tmp = list.get(i);
			arr[tmp.x][tmp.y] = su;
		}
	}
}