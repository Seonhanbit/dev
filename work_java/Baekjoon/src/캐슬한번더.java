import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬한번더 {
	static int N, M, D;
	static int[][] arr;
	static int[][] copy;
	static Queue<Arc> arc = new LinkedList<Arc>();
	static PriorityQueue<Arc> juk = new PriorityQueue<Arc>();
	static PriorityQueue<Arc> tmpq = new PriorityQueue<Arc>();
	static int dead, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
		copy = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
			}
		}
		int cnt = 0;
		dead = 0;
		max = Integer.MIN_VALUE;
		for (int j = 0; j < M; j++) {
			if (arr[N][j] == 0) {
				arr[N][j] = 2;
				dfs(cnt + 1, j);
				arr[N][j] = 0;
			}
		}
		System.out.println(max);
	}

	static void dfs(int cnt, int idx) {
		if (cnt == 3) {
			//여기서부터 뭔가 실행.
			search();
			arc.clear();
			juk.clear();
			max = Math.max(max, dead);
			dead = 0;
			return;
		}
		for (int j = idx; j < M; j++) {
			if (arr[N][j] == 0) {
				arr[N][j] = 2;
				dfs(cnt + 1, idx);
				arr[N][j] = 0;
			}
		}
	}

	static void search() {
		boolean flag = true;
		while (flag) {
			for (int j = 0; j < M; j++) {// 궁수찾아 ㅅㅂ
				if (arr[N][j] == 2) {
					arc.add(new Arc(N, j));
				}
			}
			for (int ar = 0; ar < 3; ar++) { //궁수는3마리.
				Arc a = arc.poll();
				int nr = a.r;
				int nc = a.c; // 현재 위치한 궁수의 위치를 얻고.
				for (int i = 0; i < N; i++) {// 적들을 탐색한다.
					for (int j = 0; j < M; j++) {
						if (arr[i][j] == 1) { // 적이 있따면.
							// 거리를 계산하고. 그 값이 D보다 작거나 같다면. juk 큐에 넣어준다.
							int dist = Math.abs(nr - i) + Math.abs(nc - j);
							if (dist <= D) {
								tmpq.add(new Arc(i, j, dist));
								// 적을 다찾고... 죽이는데 3명이니까 3번이고.
								// 같은위치일경우는 카운트안해서 최대로 많이 죽였을 경우를 쌓아나간다
							}
						}
					}
				}
				if (!tmpq.isEmpty())
					juk.add(tmpq.poll());
				tmpq.clear();
			}
			// 죽이기
			kill();
			int chkcnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						chkcnt++;
						break;
					}
				}
			}
			if (chkcnt == 0) { // 더이상 쏠수있는 적이 없으면 끗
				// 쐇던 위치 원래대로.
				reset();
				flag = false;
			}
		}
	}

	static void kill() {
		// 궁수가 3명이니까 총3번만 꺼내기
		for (int i = 0; i < 3; i++) {
			if (juk.isEmpty())
				break;
			Arc a = juk.poll();
			if (arr[a.r][a.c] == 1) {// 적이 존재한다면
				arr[a.r][a.c] = 0; // 오지게쏴버리긔
				dead++;
			} else {// 이미 죽었으면 그냥 컨티뉴.
				continue;
			}
		}
		juk.clear();
		arc.clear();
		// 3턴이 끝나면 이제 적들이 1칸씩 전진.
		for (int i = 0; i < M; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (j == N - 1) // 끝지점에 적들이 있따면 그냥 다 비우기.
					arr[j][i] = 0;
				else {
					if (arr[j][i] == 1) {
						// 한칸 내리고 내린위치는 0으로.
						arr[j + 1][i] = 1;
						arr[j][i] = 0;
					}
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = copy[i][j];
			}
		}
	}

	static class Arc implements Comparable<Arc> {
		int r, c;
		int dis;

		public Arc(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		public Arc(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Arc o) {
			// TODO Auto-generated method stub
			if (this.dis == o.dis) {
				return this.c - o.c;
			}
			return this.dis - o.dis;
		}
	}
}