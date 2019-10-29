import java.io.*;
import java.util.*;

//연구소2
public class Baek_17141 {
	static int N, M, ncnt, result;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<XY> list;
	static Queue<XY> queue;
	static boolean[][] visited;

	static class XY {
		int x;
		int y;
		int cnt;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소 크기 N*N
		M = Integer.parseInt(st.nextToken()); // 바이러스 개수
		arr = new int[N][N]; //input 값
		visited = new boolean[N][N]; //벽(1)일때 true해준 배열
		queue = new LinkedList<>(); //바이러스를 먼저 넣고 돌릴 큐
		list = new ArrayList<>(); //바이러스를 넣어줄 리스트
		result = Integer.MAX_VALUE; //가장 짧은 값을 구할거야
		int cnt = 0; //0 갯수를 세주기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					cnt++;
				if (arr[i][j] == 1)
					visited[i][j] = true;
				if (arr[i][j] == 2)
					list.add(new XY(i, j));
			}
		}
		//리스트를 가지고 바이러스 조합을 구하기
		combi(0, 0, new XY[M]);
		//모든 곳에 바이러스가 번지지 않을 경우
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		//바이러스 퍼질 0이 없고 바이러스 갯수가 같으면 0
		if (cnt == 0 && list.size() == M)
			result = 0;
		
		bw.append(result + "\n");
		bw.flush();
		bw.close();
	}

	static void combi(int n, int r, XY[] res) {
		if (r == res.length) {
			//1이 true된 배열은 변경해버리면 안되니까 복사해주기
			boolean[][] tmp = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				tmp[i] = Arrays.copyOfRange(visited[i], 0, tmp[i].length);
			}

			// res배열에 조합으로 M개가 뽑힘
			for (int i = 0; i < res.length; i++) {
				queue.add(new XY(res[i].x, res[i].y, 0));
			}
			// 실제 길이를 체크하는 함수
			depth(tmp);
			// 모든 곳에 다 퍼졌는지 검사하는 함수
			boolean check = check(tmp);
			if (check) {
				if (ncnt < result)
					result = ncnt;
			}
			queue.clear();
			return;
		}
		if (n == list.size())
			return;
		res[r] = list.get(n);
		combi(n + 1, r + 1, res);
		combi(n + 1, r, res);
	}

	static void depth(boolean[][] tmp) {
		while (!queue.isEmpty()) {
			XY nxy = queue.poll();
			ncnt = nxy.cnt;
			tmp[nxy.x][nxy.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = nxy.x + dx[i], ny = nxy.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (tmp[nx][ny])
					continue;
				tmp[nx][ny] = true;
				queue.add(new XY(nx, ny, nxy.cnt + 1));
			}
		}
	}

	static boolean check(boolean[][] tmp) {
		boolean ck = true;
		//모든 곳에 방문했는지 완전 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!tmp[i][j])
					ck = false;
			}
		}
		if (ck)
			return true;
		else
			return false;
	}
}
