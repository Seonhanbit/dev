package argorithm6_sub;

import java.io.*;
import java.util.*;
/*
간선수, 정점수
8 7
0 2
0 1
2 5
1 4
5 4
3 4
3 6
1 3
*/

public class 위상정렬2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int su = Integer.parseInt(st.nextToken());
		int jum = Integer.parseInt(st.nextToken());
		int[][] arr = new int[jum][jum];
		//int[] test = new int[jum];
		// 인접 행렬로 저장하기
		for (int i = 0; i < su; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			//test[b]++;
		}
		boolean[] visited = new boolean[jum];
		print(arr);
		
		while (true) {
			boolean isFinish = true;
			// 모든 정점에 대해 검사
			for (int i = 0; i < jum; i++) {
				// 부모가 있는지 없는지 검사하자
				boolean isNotParent = true;
				for (int j = 0; j < jum; j++) {
					if (arr[j][i] != 0) {
						isNotParent = false;
						break;
					}
				}
				if (isNotParent &&!visited[i]) {
					visited[i] = true;
					System.out.print(i+" ");
					isFinish = false;
					for (int j = 0; j < jum; j++) {
						arr[i][j] = 0;
					}
				}
			}
			// 부모가 없는 녀석이 없다면 break;
			if (isFinish)
				break;
		}

	}

	public static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
