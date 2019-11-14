package AD;
import java.io.*;
import java.util.*;

public class s_15686_치킨배달 {
	static int N, M, res, minn;
	static int[][] arr;
	static ArrayList<XY> home;
	static ArrayList<XY> chicken;

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		arr = new int[N][N];
		res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					home.add(new XY(i, j));
				if (arr[i][j] == 2)
					chicken.add(new XY(i, j));
			}
		}
		if (chicken.size() == M) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < home.size(); i++) {
				min = Integer.MAX_VALUE;
				XY tmp = home.get(i);
				for (int j = 0; j < chicken.size(); j++) {
					XY ntmp = chicken.get(j);
					int sum = Math.abs(tmp.x - ntmp.x) + Math.abs(tmp.y - ntmp.y);
					if (sum < min)
						min = sum;
				}
				res += min;
			}
		} else {
			minn = Integer.MAX_VALUE;
			combi(0, 0, new XY[M]);
			res = minn;
		}
		bw.write(res + "\n");
		bw.flush();
		bw.close();
	}

	static void combi(int n, int c, XY[] sel) {
		if (c == sel.length) {
			int nn = func(sel);
			//System.out.println(nn);
			if (nn < minn)
				minn = nn;
			return;
		}
		if (n == chicken.size())
			return;
		sel[c] = chicken.get(n);
		combi(n + 1, c + 1, sel);
		combi(n + 1, c, sel);
	}

	static int func(XY[] sel) {
		int fun = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < home.size(); i++) {
			min = Integer.MAX_VALUE;
			XY tmp = home.get(i);
			for (int j = 0; j < sel.length; j++) {
				XY ntmp = sel[j];
				int sum = Math.abs(tmp.x - ntmp.x) + Math.abs(tmp.y - ntmp.y);
				if (sum < min)
					min = sum;
			}
			fun += min;
		}
		return fun;
	}
}
