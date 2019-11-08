package preTest;

import java.io.*;
import java.util.*;

public class s_2112_보호필름dfs {
	static int T, D, W, K, res;
	static int[][] arr;
	
/*	1
	3 3 1         
	1 2 3
	4 5 6
	7 8 9*/

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			res = Integer.MAX_VALUE;
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			bw.append("#" + String.valueOf(tc) + " " + String.valueOf(res) + "\n");
			bw.flush();
		}
		bw.close();
	}

	public static boolean ck() {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			//1부터 앞에 있는 것을 검사하기
			for (int i = 1; i < D; i++) {
				//같으면 cnt+1해주고, 아니면 1을 리턴해주기
				cnt = arr[i - 1][j] == arr[i][j] ? cnt + 1 : 1;
				//cnt가 K와 같으면 바로 브레이크
				if (cnt == K)
					break;
			}
			//한줄 검사했는데 K보다 작으면 false리턴
			if (cnt < K)
				return false;
		}
		return true;
	}

	public static void dfs(int x, int cnt) {
		// 가지치기
		//if (cnt > res)
		//	return;
		
		// 기저조건
		if (x == D) {
			print(arr);
			System.out.println("====");
			if (ck())
				res = Math.min(cnt, res);
			return;
		}

		// 행을 깊은 미리 복사를 해두자.
		// dfs 메모리별로 다르게 저장이 되어 있어서
		// 리턴될때마다 그때 저장된 x별로 그 값이 나옴
		int[] line = arr[x].clone();

		// dfs 상태공간트리는 안바꾸고, 1로바꾸고, 0으로 바꾸고.
		dfs(x + 1, cnt);

		Arrays.fill(arr[x], 1);
		dfs(x + 1, cnt + 1);

		Arrays.fill(arr[x], 0);
		dfs(x + 1, cnt + 1);

		// 리턴될때 다시 원래 값 복귀시켜쥐
		arr[x] = line;
	}
	
	public static void print(int[][] arr) {
		for( int[]a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
