package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// 탐색을 위한 배열 넣기(오른쪽 한바퀴)
		int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

		// TC 시작이염
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			char[][] map = new char[n][n];

			// 배열에 값 넣기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}

			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					boolean chk = false;
					int cnt = 0;
					// B를 찾기
					if (map[i][j] == 'B') {
						// 주변 8개가 있어서 index 7까지야
						for (int k = 0; k < 8; k++) {
							// 주변 위치 칸을 확인하기
							int ni = i + dx[k];
							int nj = j + dy[k];
							// 끝에 있는건 찾지 못하기 때문에 continue로 밑에 문을 건너뜀
							if (ni < 0 || ni >= n || nj < 0 || nj >= n)
								continue;
							if (map[ni][nj] == 'G') {
								chk = true;
								cnt = 2;
							}
						}
						// 최고층을 찾아보자
						if (chk == false) {
							for (int d = 0; d < n; d++) {
								if (map[i][d] == 'B')cnt++;
								if (map[d][j] == 'B')cnt++;
							}
							// 자신 한번 더 더해줘서 한개 빼줌
							cnt--;
						}
					}
					// for문이 나가기 전에 전체 배열에서 찾은 cnt값을 max로 넣어주기
					if (max < cnt)
						max = cnt;
				}
			}
			System.out.println("#" + tc + " " + max);
		} // TC 끝
	}
}
//출력
//for(int i=0; i<n;i++) {
//for(int j=0; j<n; j++) {
//	System.out.print(map[i][j]);
//}
//System.out.println();
//}
