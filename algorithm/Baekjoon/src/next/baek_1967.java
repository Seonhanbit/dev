package new_;

import java.io.*;
import java.util.*;

// 숨바꼭질
public class baek_1967 {
	static int N, K, min;
	static boolean[] ck;

	static class XY {
		int val;
		int cnt;

		XY(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}

	static boolean range(int x) {
		return x >= 0 && x <100001;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈 위치 +1 또는 -1 2*N
		K = Integer.parseInt(st.nextToken()); // 동생 위치
		ck = new boolean[100001];
		min = Integer.MAX_VALUE; // 가장 낮은 값
		if (N == K)
			min = 0;
		else
			bfs();
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<XY> queue = new LinkedList<XY>();
		queue.add(new XY(N, 0));
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			ck[tmp.val] = true;

			System.out.println(tmp.val + " " + tmp.cnt);

			if (tmp.val == K) {
				min = tmp.cnt;
				break;
			}

			if (tmp.val < 0)
				continue;

			if (range(tmp.val+1)&&!ck[tmp.val + 1])
				queue.add(new XY(tmp.val + 1, tmp.cnt + 1));
			if (range(tmp.val-1)&&!ck[tmp.val - 1])
				queue.add(new XY(tmp.val - 1, tmp.cnt + 1));
			if (range(tmp.val*2)&&!ck[tmp.val * 2])
				queue.add(new XY(tmp.val * 2, tmp.cnt + 1));
		}
	}
}
