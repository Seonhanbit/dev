package AD;

import java.io.*;
import java.util.*;

public class s_17135_캐슬디펜스 {
	static int N, M, D, res;
	static int[][] arr;
	static int[] sel;

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static class XY implements Comparable<XY> {
		int x;
		int y;
		int dist;

		XY(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(XY o) {
			if (this.dist == o.dist)
				return this.y - o.y;
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
		int[] narr = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
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
	//궁수 위치 조합
	public static void combi(int[] narr, int n, int c) {
		if (c == sel.length) {
			int cnt = func();
			//System.out.println("===" + cnt);
			if (cnt > res)
				res = cnt;
			return;
		}
		if (n == narr.length)
			return;
		sel[c] = narr[n];
		combi(narr, n + 1, c + 1);
		combi(narr, n + 1, c);
	}

	//거리 구하기
	static int ck(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}

	public static int func() {
		int cnt = 0;
		if (D == 1) {
			//거리가 1일때는 앞에 놈만 보면 돼
			for (int k = 0; k < sel.length; k++) {
				for (int i = 0; i < N; i++) {
					if (arr[i][sel[k]] == 1)
						cnt++;
				}
			}
		} else {
			//아닐때는 쏜놈 tmp에 2로 바꿔가면서 계산할거야
			int[][] tmp = new int[N + 1][M];
			for (int i = 0; i < N; i++) {
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);
			}
			//pq로 가장 가까운 거리를 구해서 앞에 놈만 볼거야(거리순, 같으면 왼쪽으로 정렬되어있음)
			PriorityQueue<XY> queue = new PriorityQueue<>();
			Queue<XY> shotqueue =new LinkedList<>();
			// 궁수 위치는 sel에 담겨있음
			//for (int k = 0; k < sel.length; k++) 
				//System.out.println("sel : " + sel[k]);
			
			// 궁수는 N칸에 있고, 한칸씩 앞으로 갈거야
			for (int i = N; i >= 0; i--) {
				// 궁수 세마리가 적 위치를 볼건데
				for (int k = 0; k < sel.length; k++) {
					// 한바퀴 돌면서 쏠 수 있는 적을 큐에 담을거야
					for (int l = i - 1; l >= 0; l--) {
						for (int j = 0; j < M; j++) {
							if (ck(i, sel[k], l, j) <= D && tmp[l][j] == 1) {
								queue.add(new XY(l, j, ck(i, sel[k], l, j)));
							}
						}
					}
					//쏠 놈이 있으면 가장 앞에 있는 것 빼고 큐 비워주기 
					//가장 앞에 있는 놈이 한바퀴 돌고 죽일놈인데...
					if (queue.size() != 0) {
						shotqueue.add(queue.poll());
						//System.out.println(tq.x + "," + tq.y + " " + tq.dist);
						//tmp[tq.x][tq.y] = 2;
						queue.clear();
					}
				}
				while(!shotqueue.isEmpty()) {
					XY tq = shotqueue.poll();
					tmp[tq.x][tq.y] = 2;
				}
				//System.out.println("-----");
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//System.out.print(tmp[i][j]+" ");
					if (tmp[i][j] == 2)
						cnt++;
				}//System.out.println();
			}

		}
		//System.out.println("====");
		return cnt;
	}
}
