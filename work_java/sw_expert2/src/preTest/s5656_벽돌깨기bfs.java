package preTest;

import java.io.*;
import java.util.*;

//압축시키기 아이디어 참고
//bfs 아이디어 참고
public class s5656_벽돌깨기bfs {
	static int T, N, W, H, res;
	static int[][] arr;
	static int[][] tmp;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			tmp = new int[H][W];
			res = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 구슬을 때릴건데
			// 0번째 행 쭉 때려보고, 마지막만 1번쨰행..마지막만 2번째행..마지막만 3번쨰행
			// 재귀를 돌아보자
			// 돌기전에 뽑을 열을 고를 배열 준비하자(체크 배열은 N만큼 있으면 돼)
			sel = new int[N];
			dfs(0);
			bw.append("#" + tc + " " + res + "\n");
			bw.flush();
		}
		bw.close();
	}

	// 재귀를 돌때 idx를 늘어가면서 기저조건은 N일때
	static void dfs(int idx) {
		if (idx == N) {
			// 원본 배열은 바뀌면 안되니까 배열을 복사해주자.
			for (int i = 0; i < H; i++) {
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);
			}
			// sel에 뽑힌 배열의 숫자 행을 검사할거야(이제부터 구현 ^^~)
/*			for (int i = 0; i < sel.length; i++)
				System.out.print(sel[i] + " ");
			System.out.println("=============");*/
			punch();
			// 벽돌 개수 작은놈 구하기
			int cnt = check();
			res = Math.min(res, cnt);
			return;
		}
		// 행의 갯수만큼 돌면서 중복으로 뽑기
		for (int i = 0; i < W; i++) {
			sel[idx] = i;
			dfs(idx + 1);
		}
	}

	// sel에 뽑힌 배열의 숫자 행을 한번씩 때릴건데,
	// 때리고 배열 압축 때리고 배열 압축
	static void punch() {
		for (int k = 0; k < sel.length; k++) {
			int c = sel[k];
			for (int i = 0; i < H; i++) {
				// 때릴 행을 잡고 밑으로 0이 아닐때까지 가보기
				if (tmp[i][c] != 0) {
					// 한번 때리기
					realpunch(i, c, tmp[i][c]);
					// 배열 압축하기
					push();
					// 한번 떄리고 나가야해
					break;
				}
			}
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < H && y < W;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static class XY {
		int x;
		int y;
		int val;

		XY(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	// 상하좌우 때리는 함수
	static void realpunch(int x, int y, int val) {
		visited = new boolean[H][W];
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(x, y, val));
		while (!queue.isEmpty()) {
			XY pp = queue.poll();
			//System.out.println(pp.x+","+pp.y+" : "+pp.val);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < pp.val; j++) {
					int nx = pp.x + dx[i] * j, ny = pp.y + dy[i] * j;
					if (!range(nx, ny))
						continue;
					if (visited[nx][ny])
						continue;
					if (tmp[nx][ny] == 0)
						continue;
					//System.out.println("??????????");
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny, tmp[nx][ny]));
					tmp[nx][ny] = 0;
				}
			}
		}
	}

	// 배열 압축
	static void push() {
/*		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");*/
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int j = 0; j < W; j++) {
			for (int i = H - 1; i >= 0; i--) {
				if (tmp[i][j] > 0)
					queue.add(tmp[i][j]);
			}
			for (int i = H - 1; i >= 0; i--) {
				if (queue.isEmpty()) {
					tmp[i][j] = 0;
					continue;
				}
				tmp[i][j] = queue.poll();
			}
		}
/*		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");*/
	}

	// 남은 벽돌의 개수를 구하자
	static int check() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (tmp[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}
}
