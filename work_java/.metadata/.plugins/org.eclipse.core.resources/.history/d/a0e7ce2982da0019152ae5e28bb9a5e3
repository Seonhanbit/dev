package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_1251_하나로 {
	static int N;
	static int[] parents;

	static class XY implements Comparable<XY>{
		int x;
		int y;

		public XY() {
			super();
		}

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(XY o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			parents = new int[N];
			XY[] arr = new XY[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				arr[k] = new XY();
				arr[k].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				arr[k].y = Integer.parseInt(st.nextToken());
			}
			// 입력끝-----------------------------------------

			// 기본 값 넣어두기
			for (int k = 0; k < N; k++) {
				parents[k] = k;
			}

		}
	}

	static int findSet(int x)
}
