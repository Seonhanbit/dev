package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class s_7699_수지의수지맞는여행 {
	static int R;
	static int C;
	static char[][] arr = null;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int res;
	static HashSet<Character> hs;

	public static boolean range(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new char[R][C];
			res = Integer.MIN_VALUE;
			for (int i = 0; i < R; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			hs = new HashSet<>();
			dfs(0, 0, 1);

			System.out.println("#" + tc + " " + res);
		}
	}

	public static void dfs(int x, int y, int cnt) {
//		System.out.println(arr[x][y]);
		if(res==26)//알파벳은 26개
			return;
		hs.add(arr[x][y]);
		if (cnt > res)
			res = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i], ny = y + dc[i];
			if (!range(nx, ny))
				continue;
			if (hs.contains(arr[nx][ny]))
				continue;
			dfs(nx, ny, cnt + 1);
			hs.remove(arr[nx][ny]);
		}
	}
}
