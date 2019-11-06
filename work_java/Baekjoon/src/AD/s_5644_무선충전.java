package AD;

import java.io.*;
import java.util.*;

public class s_5644_무선충전 {
	static int M, A, m, n, res;
	static int[] person1;
	static int[] person2;
	static BC[] bc;
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	static class BC implements Comparable<BC> {
		int x;
		int y;
		int c;
		int p;

		BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}

		@Override
		public int compareTo(BC o) {
			return this.p - o.p;
		}

	}

	static boolean ck(int x, int x1, int y, int y1, int c) {
		if (Math.abs(x - x1) + Math.abs(y - y1) <= c)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			person1 = new int[M];
			person2 = new int[M];
			for (int i = 0; i < M; i++) {
				person1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				person2[i] = Integer.parseInt(st.nextToken());
			}
			bc = new BC[A];
			for (int k = 0; k < A; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bc[k] = new BC(y, x, c, p);
			}
			res = 0;

			int p1x = 1;
			int p1y = 1;
			int p2x = 10;
			int p2y = 10;

			for (int i = 0; i <= M; i++) {
				// 충전
				ArrayList<BC> p1_list = func(p1x, p1y);
				ArrayList<BC> p2_list = func(p2x, p2y);

				if (p1_list.size() != 0 && p2_list.size() == 0) {
					res += Collections.max(p1_list).p;
				}

				if (p1_list.size() == 0 && p2_list.size() != 0) {
					res += Collections.max(p2_list).p;
				}

				if (p1_list.size() != 0 && p2_list.size() != 0) {
					int max = 0;
					for (int j = 0; j < p1_list.size(); j++) {
						for (int k = 0; k < p2_list.size(); k++) {
							int tmp = p1_list.get(j).p + p2_list.get(k).p;
							//전체가 똑같은 것
							if (p1_list.get(j) == p2_list.get(k))
								tmp /= 2;
							max = Math.max(tmp, max);
						}
					}
					res += max;
				}
				//첫번째 자기자신 위치에서 한번 충전하니까 M+1번 해주는데 이동 전에 끝!
				if (i == M)
					break;
				// 이동
				p1x += dx[person1[i]];
				p1y += dy[person1[i]];
				p2x += dx[person2[i]];
				p2y += dy[person2[i]];
			}
			bw.write("#" + tc + " " + res + "\n");
			bw.flush();
		}
		bw.close();
	}

	public static ArrayList<BC> func(int x, int y) {
		ArrayList<BC> list = new ArrayList<>();
		for (int i = 0; i < bc.length; i++) {
			if (ck(bc[i].x, x, bc[i].y, y, bc[i].c))
				list.add(bc[i]);
		}
		return list;
	}

}
