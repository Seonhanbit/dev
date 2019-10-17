package argorithm5_복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek_1717 {
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			parents[i] = i;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
			} else {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (find(x) == find(y))
					bw.write("YES" + "\n");
				else
					bw.write("NO" + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static void union(int x, int y) {
		x=find(x);
		y=find(y);
		
		if (rank[x] > rank[y])
			parents[y] = x;
		else {
			parents[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
}
