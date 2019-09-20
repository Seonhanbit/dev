package sw_expert;

import java.util.Scanner;

public class s_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 오른쪽 , 아래, 왼쪽 , 위로
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };

			int num = 1;
			int i = 0;
			int j = 0;
					
			while(num<=N*N) {
				map[i][j] = num;
				mode%4==0{
					arr[][]
				}
						
				
						
						num++;
			}

		

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
				}System.out.println();
			}
		}

	}

}
