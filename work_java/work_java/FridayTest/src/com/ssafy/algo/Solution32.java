package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution32 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = { 0, 0, 1, 0, -1 };
		int[] dy = { 0, 1, 0, -1, 0 };

		for (int tc = 1; tc <= T; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[][] coin = new int[x+1][y+1];
			int user = sc.nextInt();
			int[][] user_info = new int[user][4];

			for (int i = 1; i <= x; i++) {
				for (int j = 1; j <= y; j++) {
					coin[i][j] = sc.nextInt();
				}
			}
			// 참가자 받기
			for (int i = 0; i < user; i++) {
				user_info[i][0] = sc.nextInt();
				user_info[i][1] = sc.nextInt();
				user_info[i][2] = sc.nextInt();
				user_info[i][3] = -1000;
			}
			// 함정 받기
			int ham = sc.nextInt();
			for (int i = 0; i < ham; i++) {
				int ham_row = sc.nextInt();
				int ham_col = sc.nextInt();
				coin[ham_row][ham_col] = 0;
			}
			// 게임 시작
			int result= 0;
			for (int i = 0; i < user; i++) {
				boolean chk = true;
				int nx = user_info[i][0];
				int ny = user_info[i][1];
				int chance = user_info[i][2];
				for (int j = 0; j < chance; j++) {
					int dir = coin[nx][ny] / 10;
					int jump = coin[nx][ny] % 10;

					nx += dx[dir] * jump;
					ny += dy[dir] * jump;

					if (nx <= 0 || nx > x || ny <= 0 || ny > y ||coin[nx][ny]==0) {
						chk = false;
						user_info[i][3]= -1000;
						break;
					}
				}
				if(chk == true) {
					user_info[i][3] += coin[nx][ny]*100;
				}
			}
			for(int i=0; i<user; i++) {
				result += user_info[i][3];
			}
			System.out.println("#" + tc + " "+result);
		}
	}
}
