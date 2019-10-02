package October;

import java.util.Scanner;

public class s_2630_강사님코드 {
	static int N;
	static int[][] map;
	static int black = 0 , white = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		check(0, 0, N);
		System.out.println(white);
		System.out.println(black);
	}
	static void check(int r, int c, int size) {
		int color = map[r][c];
		//r,c 에서 size만큼의 행열을 순회하면서 color와 다른 색이 발견되면 4개의 조각에 대해 재귀콜 후 return;
		
		for(int i = r; i < r + size; i++	) {
			for(int j = c; j < c + size; j++) {
				if( color != map[i][j] ) {
					check(r, c, size / 2);
					check(r +  size / 2, c, size / 2);
					check(r, c +  size / 2, size / 2);
					check(r +  size / 2, c +  size / 2, size / 2);
					return;
				}
			}
		}
		//반복 순회 후 리턴안당하고 여까지 왔으면 color에 해당하는 친구 ++
		if( color == 1)
			black++;
		else
			white++;
	}
}
