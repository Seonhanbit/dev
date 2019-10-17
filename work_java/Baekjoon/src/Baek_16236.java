
import java.io.*;
import java.util.*;

public class Baek_16236 {
	static int N, res;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static ArrayList<XY> list;

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

	static boolean range(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}

		res = 0;

		bw.write(res + "\n");
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y, int cnt) {
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(x, y, cnt));
		int shark = 2;
		int size = 0;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			visited[tmp.x][tmp.y] = true;
			if(shark==size)
				shark++;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[ny][ny])
					continue;
				if (arr[nx][ny] > arr[x][y])
					continue;

				list.add(new XY(nx, ny, cnt));
				visited[nx][ny] = true;
				queue.add(new XY(nx, ny, cnt + 1));
			}
		}
		// 리스트가 0이면 끝내고 아니면 아래로
		if (list.size() == 0)
			return;
		// 리스트 정렬, 상어위치 바꾸기
		Collections.sort(list, new Comparator<XY>() {

			@Override
			public int compare(XY o1, XY o2) {
				if (o1.cnt == o2.cnt) {
					if (o1.x == o2.x)
						return o1.y - o2.y;
					return o1.x - o2.x;
				}
				return o1.cnt - o2.cnt;
			}
		});
		arr[list.get(0).x][list.get(0).y] = arr[x][y];
		arr[x][y] = 0;
		// 재귀로 bfs소환하기

	}

}
