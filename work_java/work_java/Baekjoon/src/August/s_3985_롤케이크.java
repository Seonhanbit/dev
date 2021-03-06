package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_3985_롤케이크 {
	static class XY {
		int x;
		int y;
		int sub;

		public XY(int a, int b, int c) {
			x = a;
			y = b;
			sub = c;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[L + 1];
		XY[] xy = new XY[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int xx = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			xy[i] = new XY(xx, yy, yy - xx);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (xy[i].x == j) {
					for (int k = j; k <= xy[i].y; k++) {
						if (arr[k] == 0)
							arr[k] = i + 1; // 첫번쨰다
					}
				}
			}
		}

		// 가장 많은 조각을 받을 것으로 기대한다
		int max = 0;
		int max_sub = 0;
		for (int i = 0; i < N; i++) {
			if (xy[i].sub > max) {
				max = xy[i].sub;
				max_sub = i + 1;
			}
		}
		System.out.println(max_sub);
		int[] ck = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			int cnt = 0;
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] != 0 && arr[j] == i) {
					cnt++;
				}
			}
			ck[i] = cnt;
		}
		max = 0;
		max_sub = 0;
		for (int i = 1; i < N + 1; i++) {
			if(ck[i]>max) {
				max = ck[i];
				max_sub = i;
			}
		}
		System.out.println(max_sub);

//		System.out.println(Arrays.toString(arr));

	}
}
