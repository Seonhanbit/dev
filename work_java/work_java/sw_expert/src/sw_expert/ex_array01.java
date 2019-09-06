package sw_expert;

import java.util.Scanner;

public class ex_array01 {
	// 중력 이차원 배열 연습 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] input = new int[N][N];
//		int N=10;
//		int[][] input = new int[10][10];

		int[] box = { 7, 4, 2, 0, 0, 6, 0, 7, 0, 0 };

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < box[j]; i++) {
				input[N - 1 - i][j] = 1;
			}
		}
//        box[9][1]=1;
//        box[8][1]=1;
//        box[7][1]=1;

		// 돌리기(회전) 규칙 : (N-1,0) > (0,0), (N-1-1, 0) > (0,1)
		// (N-1-i, 0) > (0,i), (N-1-i, 1) > (0,i)
		int[][] r_map = new int[N][N];

//		for(int i =0; i<N; i++) {
//			r_map[0][i] = r_map[N-1-i][0];
//		}
//		for(int i =0; i<N; i++) {
//			r_map[1][i] = r_map[N-1-i][1];
//		}
		// 회전 시작
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				r_map[j][i] = input[N - 1 - i][j];
			}
		}

		// 출력
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j]);
			}
			System.out.println();
		}

		System.out.println("회전 후========================");
		for (int i = 0; i < r_map.length; i++) {
			for (int j = 0; j < r_map[i].length; j++) {
				System.out.print(r_map[i][j]);
			}
			System.out.println();
		}

		// 위치 길이 찾기
		int max = 0;
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (r_map[i][j] == 1) {
//				System.out.println(i +"번째 행에 1이 있어요(0열)");
//				출력 대신에, 내 자리자 맨 아래줄이 아니고, 내 아래줄이 1이 아니라면 
//				'반복'해서 아래로 내리고 카운트++
					int cur_row = i;
					int cnt = 0;
//				내가 마지막 줄이 아니고, 내 아랫줄이 1이 아닌 조건 
					// 반복해야하기 때문에 if 말고 while
					while (cur_row != N - 1 && r_map[cur_row + 1][j] != 1) {
						r_map[cur_row][j]--; // 현재 내 자리 0을 만들기
						r_map[cur_row + 1][j]++; // 내 자리 밑에 있는애를 1로 만들기
						cnt++;
						cur_row++; // 현재 위치 아래 하나 이동
					}
					max = Math.max(max, cnt);
				}
			}
		}
		
		System.out.println("큰 낙차 ========================" + max);

//		for(int i =N-1; i>=0; i--) {
//			if(r_map[i][0]==1)
//			{
////				System.out.println(i +"번째 행에 1이 있어요(0열)");
////				출력 대신에, 내 자리자 맨 아래줄이 아니고, 내 아래줄이 1이 아니라면 
////				'반복'해서 아래로 내리고 카운트++
//				int cur_row =i;
//				int cnt = 0;
////				내가 마지막 줄이 아니고, 내 아랫줄이 1이 아닌 조건 
//				//반복해야하기 때문에 if 말고 while
//				while(cur_row != N-1 && r_map[cur_row+1][0] !=1)
//				{
//					r_map[cur_row][0]--; //현재 내 자리 0을 만들기
//					r_map[cur_row+1][0]++; //내 자리 밑에 있는애를 1로 만들기
//					cnt++;
//					cur_row++; //현재 위치 아래 하나 이동
//				}
//			}
//		}
		//배열 중 나보다 작은 숫자 갯수 구하기 
//		int max = 0;
//		for(int i=0; i<input.length; i++)
//		{
//			int cnt = 0;
//			
//			for (int j=0; j<input.length; j++){
//				if(input[i] > input[j])
//					cnt++;
//			}
//			max = Math.max(max,cnt);
//		}
	}

}
