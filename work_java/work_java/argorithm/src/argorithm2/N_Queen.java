package argorithm2;

import java.util.Arrays;
import java.util.Scanner;

public class N_Queen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 체스판의 크기이자 퀸의 수
			int[][] map = new int[N][N];
			cnt = 0;
			// 한줄에 하나의 퀸은 들어가야한다
			backtrack(map, 0);
			System.out.println("#" + tc + " " + cnt);
			// 아래의 케이스를 입력을 쓰시고, 입력된 map이 N_Queen인지 판단하는 프로그램 작성
		}
	}

	static int cnt = 0;
	static int callCnt=0;

	// idx는 현재 퀸을 배치하려고 하는 행
	static void backtrack(int[][] map, int idx) {
		callCnt++;
		// 모든 행을 다 검사했음
		if (idx == map.length) {
//			for(int i=0;i<map.length;i++)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println("-----------------------------");

			boolean isNQueen = true;
			loop: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 1) {
						// 왼쪽 위부터 오른쪽 아래로 검색하고 한 행에는 하나의 퀸만 존재하기 떄문에
						// 8방 중에서 좌상 상 우상 좌 우는 안봐도됨

						// 아래로 탐색
						for (int k = i + 1; k < map.length; k++) {
							if (map[k][j] == 1) {
								isNQueen = false;
								break loop;
							}
						}
						// 좌하...탐색 > 왼쪽 대각선
						for (int m = i + 1, n = j - 1; m < map.length && n >= 0; m++, n--) {
							if (map[m][n] == 1) {
								isNQueen = false;
								break loop;
							}
						}
						// 오른쪽 대각선
						for (int m = i + 1, n = j + 1; m < map.length && n < map[m].length; m++, n++) {
							if (map[m][n] == 1) {
								isNQueen = false;
								break loop;
							}
						}
					}
				}
			}
			if (isNQueen)
				cnt++;
			return;
		}
		// 해당 행의 열의 갯수만큼 반복하며 해당 열에 퀸을 배치하고 다음 행 재귀 호출
		// 퀸이 있는 자리는 1, 아니면 0

		for (int i = 0; i < map[idx].length; i++) {
			if (canBeNQueen(map, idx, i)) {
				map[idx][i] = 1;
				backtrack(map, idx + 1);
				map[idx][i] = 0;
			}
		}

	}

	static boolean canBeNQueen(int[][] map, int r, int c) {
		// 일단 위로 올라가면서 또다른 퀸을 만나면 리턴 펄스
		for (int i = r - 1; i >= 0; i--) {
			if (map[i][c] == 1)
				return false;
		}
		//좌상으로 올라가면서 또다른 퀸을 만나면 리턴 펄스!
		for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1)
				return false;
		}
		//우상으로 올라가면서 또다른 퀸을 만나면 리턴 펄스!		
		for (int i = r - 1, j = c + 1; i >= 0 && j < map[i].length; i--, j++) {
			if (map[i][j] == 1)
				return false;
		}
		return true;
	}
}
