package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		//상하좌우
		//다른 방법 
		//static int [][] delta = {{0}, {-1,0}, {1,0}, {0,-1}, {0,1}}
		//row += delta[dir][0]*6;
		//sol += delta[dir][1]*6;
		int[] dx = { 0, -1, 1, 0, 0 };
		int[] dy = { 0, 0, 0, -1, 1 };
		
		// TC 시작이염
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int [][] map = new int[n][n];

			int bug = sc.nextInt();
			int result = bug;
			
			for(int i =0; i<bug; i++)
			{
				boolean chk = true;
				
				int row = sc.nextInt();
				int col = sc.nextInt();
				int dir = sc.nextInt();
				//6번 건너뛰기, 최종 위치
				row += (dx[dir]*6);
				col += (dy[dir]*6);
				//종료 조건은 2개
				if(row<0 || row>=n || col<0 || col>=n) {
					result --;
					chk = false;
					continue;
				}
				if(map[row][col] ==1) {
					result --;
					chk =false;
					continue;
				}
				if(chk==true) {
					map[row][col] =1;
				}				
			}
			System.out.println("#" + tc + " " + result);	
		}
	}
}
