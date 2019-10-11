package D5;

import java.io.*;
import java.util.*;

public class s_7396_종구딸이름짓기 {
	static int N, M, su;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };
	static char[] res;

	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}

	static class XY {
		int x;
		int y;
		int cnt;

		XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			visited = new boolean[N][M];
			su = N + M - 1;
			res = new char[su];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				arr[i] = str.toCharArray();
			}
			Arrays.fill(res, 'z');
			res[0] = arr[0][0];
			bfs(new XY(0, 0, 0));

			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for (int i = 0; i < res.length; i++)
				sb.append(res[i]);
			sb.append("\n");
			bw.write(sb.toString());
			bw.flush();
		}
		bw.close();
	}

	static void bfs(XY xy) {
		Queue<XY> queue = new LinkedList<>();
		queue.add(xy);
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			//System.out.println(tmp.x + "," + tmp.y);
			visited[tmp.x][tmp.y] = true;

			if (res[tmp.cnt] < arr[tmp.x][tmp.y])
				continue;

			for (int i = 0; i < 2; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i], ncnt = tmp.cnt + 1;
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (ncnt > su - 1)
					continue;
				if (res[ncnt] < arr[nx][ny])
					continue;

				res[ncnt] = arr[nx][ny];
				visited[nx][ny] = true;
				queue.add(new XY(nx, ny, ncnt));
			}
		}
	}

}
