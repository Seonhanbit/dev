package jungol;

import java.io.*;
import java.util.*;

public class s1681_해밀턴순환회로 {
	static int N, res;
	static int[][] arr;
	static boolean[] ck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			if (arr[0][i] == 0)
				continue;
			ck = new boolean[N];
			func(i, 0, arr[0][i]);
		}
		bw.append(res + "\n");
		bw.flush();
		bw.close();
	}
	
	//상태공간 트리를 그린 후 필요한 인자를 담기
	static void func(int j, int cnt, int value) {
		if (value > res)
			return;
		if (cnt == N - 1 && j == 0) {
			//System.out.println("value : " + value);
			if (value < res)
				res = value;
		}
		if (cnt == N - 1)
			return;
		for (int i = 0; i < N; i++) {
			if (arr[j][i] == 0)
				continue;
			if (!ck[i] && value + arr[j][i] < res) {
				ck[j] = true;
				//System.out.println(j + "," + i+" : "+arr[j][i]);
				func(i, cnt + 1, value + arr[j][i]);
				ck[j] = false;
			}
		}
	}
}
