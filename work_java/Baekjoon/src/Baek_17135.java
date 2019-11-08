
import java.io.*;
import java.util.*;

//캐슬디펜스
public class Baek_17135 {
	static int N, M, D, res;
	static int[][] arr;
	static int[] sel;
	static PriorityQueue<XY> pq;
	static Queue<XY> queue;

	static class XY implements Comparable<XY> {
		int r, c;
		int dist;

		public XY(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(XY o) {
			if (this.dist == o.dist)
				return this.c - o.c;

			return this.dist - o.dist;
		}

		@Override
		public String toString() {
			return "XY [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}

	}

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static int[][] tmparr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N +1][M];
		int[] narr = new int[M];
		pq = new PriorityQueue<>();
		queue = new LinkedList<>();
		tmparr = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				tmparr[i][j] = arr[i][j];

			}
		}
		for (int j = 0; j < M; j++) {
			narr[j] = j;
		}
		sel = new int[3];
		res = Integer.MIN_VALUE;
		combi(narr, 0, 0);
		bw.write(res + "\n");
		bw.flush();
		bw.close();
	}

	// M줄에 궁수가 갈 수 있는 조합을 뽑기
	public static void combi(int[] narr, int n, int c) {
		if (c == sel.length) {
			reset();
			int cnt = func();

			// 조합에서 죽일 수 있는 적 갯수 중 제일 큰 놈을 구해보자
			// System.out.println("===" + cnt);
			if (cnt > res)
				res = cnt;
			queue.clear();
			pq.clear();
			return;
		}
		if (n == narr.length)
			return;
		sel[c] = narr[n];
		combi(narr, n + 1, c + 1);
		combi(narr, n + 1, c);
	}

	public static int ck(int x, int x1, int y, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}

	public static int func() {
		ArrayList<XY> list = new ArrayList<>();
		// sel배열에 궁수가 갈 M(번호)이 적혀져 있음
		for (int k = 0; k < sel.length; k++) {
			list.add(new XY(N, sel[k], 0));
		}

		int m = 0;
		int cnt = 0;
		while (m <= N) {
			System.out.println("m: "+m);
			for (int k = 0; k < list.size(); k++) {
				pq.clear();
				XY tmp = list.get(k);
				
				for (int i = 0; i < N; i++) {
					// pq초기화
					for (int j = 0; j < M; j++) {
						// pq에 넣고
						if (arr[i][j] == 1) {
							System.out.println("아오!@");
							int dist = ck(i, tmp.r, j, tmp.c);
							if (dist <= D) {
								pq.add(new XY(i, j, dist));
							}
							System.out.println(i+" "+j+" "+dist);
						}
					}
				}
				XY p = pq.poll();
				System.out.println(p.r + " " + p.c);
				queue.add(p);
				pq.clear();
			}//-----
			System.out.println(queue);
			// 쏘고
			while (!queue.isEmpty()) {
				XY tmp = queue.poll();
				System.out.println(tmp.r+" "+tmp.c);
				if (arr[tmp.r][tmp.c] == 1) {
					cnt++;
					arr[tmp.r][tmp.c] = 0;
				} else if (arr[tmp.r][tmp.c] == 0) {
					continue;
				}
			}
			queue.clear();
			System.out.println("탈출");
			// 0으로 바꿔주고
			
			for (int j = 0; j < M; j++) {
				arr[N - 1][j] = 0;
			}
			// 배열 한칸씩 내리기
			for (int i = N - 2; i > 0; i--) {
				for (int j = 0; j < M; j++) {
					arr[i + 1][j] = arr[i][j];
				}
			}
			System.out.println("탈출2");
			m++;
		}
		return cnt;
	}

	static void reset() {
		for (int i = 0; i < N + 1; i++)
			arr[i] = tmparr[i].clone();
	}
}
