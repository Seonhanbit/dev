package sw_expert;

import java.util.Scanner;

public class s_1210_Ladder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			 sc.nextInt();
			// 각 사다리 모양을 입력 받기
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 열탐색하면서 세로 막대 위치와 목적지 위치 열 인덱스 찾기
			// 세로 막대 위치는 배열에 저장하고 목적지 위치는 정수 변수에 담아 놓기
			int[] stick = new int[100];
			int col_idx = 0; //현재 내가 탐색하는 열의 위치를 저장 
			int idx = 0;

			// 사다리 맵 마지막 줄을 첫칸 부터 끝칸까지 탑색하면서 1이나 2찾기
			for (int j = 0; j < 100; j++) {
				if (arr[99][j] == 1) {
					stick[idx] = j;
					idx++;
				}
				if (arr[99][j] == 2) {
					col_idx = idx; //stick의 인덱스를 기억하는게 더 중요하다
					stick[idx] = j;
					idx++;
				}
			}
			
			int row =99; // 맨 아랫줄을 현재 행의 위치로.
			
			//맨 윗줄에 닿을때까지 ㄱㄱ
			while(row>0) {
				if(col_idx > 0&& arr[row][stick[col_idx]-1] ==1) {
					col_idx--;
				}
				else if(col_idx < idx-1 && arr[row][stick[col_idx]+1] ==1) {
					col_idx++;
				}
				row--;
			}

			System.out.println("#" + tc + " " + stick[col_idx]);
		}
	}

}
