package AD;

import java.io.*;
import java.util.*;

public class s16987_계란으로계란치기 {
	static int N, res;

	static class Egg implements Comparable<Egg> {
		int s;
		int w;

		Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}

		@Override
		public int compareTo(Egg o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Egg[] egg = new Egg[N];
		res = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Egg tmp = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			egg[i] = tmp;
		}
		dfs(egg, 0);
		bw.append(res + "\n");
		bw.flush();
		bw.close();
	}

	static void dfs(Egg[] egg, int cnt) {
		if (cnt == egg.length) {
			int n = 0;
			for (int i = 0; i < egg.length; i++) {
				if (egg[i].s <= 0)
					n++;
			}
			res = Math.max(n, res);
			return;
		}
		boolean ck = false;
		Egg myEgg = egg[cnt];
		for (int i = 0; i < egg.length; i++) {
			if (i == cnt)
				continue;
			if(myEgg.s<=0)
				break;
			if (egg[i].s > 0) {
				ck = true;
				myEgg.s -= egg[i].w;
				egg[i].s -= myEgg.w;
				dfs(egg, cnt + 1);
				myEgg.s += egg[i].w;
				egg[i].s += myEgg.w;
			}
		}
		if(!ck)
			dfs(egg, cnt + 1);
	}
}
