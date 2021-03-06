package September;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s_1012_유기농배추 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static Queue<Q> queue;
	static int[][] arr;
	static int M = 0;
	static int N = 0;
	static int sum = 0;

	public static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}

	static class Q {
		int x;
		int y;

		Q(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int k = sc.nextInt();
			arr = new int[N][M];
			visit = new boolean[N][M];
			
			for (int n = 0; n < k; n++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				arr[x][y] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
//						bfs(i, j);
						if (!visit[i][j]) {
							dfs(i, j);
							sum++;
						}
					}
				}
			}

			System.out.println(sum);
			sum = 0;

		}
	}

	// 깊이
	static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (!range(nx, ny) || arr[nx][ny] != 1 || visit[nx][ny])
				continue;
			visit[nx][ny] = true;
			dfs(nx, ny);
		}
	}

	// 너비
	public static void bfs(int x, int y) {
		// 1. 큐를 생성하여 들어가는 x,y 좌표를 넣고, 방문 체크를 한다
		// 큐에는 상태 공간 트리에서 가져갈 것을 넣어야됨
		// 2. 무한루프를 들어가서 자기 위치는 꺼내고, 자기가 검사하고 싶은(4방향) 방향을 검사한다
		// 3. range 검사
		// 4. 방문했는지 안했는지 배열을 검사 후, 다음 1의 값인 좌표를 큐에 넣는다 또다시 방문 체크
		// 5. 한바퀴 돌고 sum을 추가하기

		if (visit[x][y])
			return;

		queue = new LinkedList<Q>();
		queue.add(new Q(x, y));
		visit[x][y] = true;
		while (!queue.isEmpty()) {
			Q temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int next_x = temp.x + dx[i], next_y = temp.y + dy[i];
				if (!range(next_x, next_y))
					continue;
				if (visit[next_x][next_y])
					continue;
				if (arr[next_x][next_y] != 1)
					continue;
				// 할거
				queue.add(new Q(next_x, next_y));
				visit[next_x][next_y] = true;
			}
		}
		sum++;
	}

}
