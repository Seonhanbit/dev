package movie;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieMgr man = MovieMgr.getInstance();

		System.out.println("<<< 영화 관리 프로그램 >>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 정보 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택하세요.");

		while (true) {
			Scanner sc = new Scanner(System.in);

			int T = sc.nextInt();

			switch (T) {
			case 0:
				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			}

		}

	}

}
