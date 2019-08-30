package sw_expert;

import java.util.Scanner;

public class 원재의메모리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			//정수로 받으면 앞에 0 무시되기도 하고, 메모리 적으로 50은 int로 담을 수 없음.
			char[] input = sc.next().toCharArray(); 
			char[] temp = new char[50]; // 0~50이하 또는 input.length

			for (int i = 0; i < input.length; i++) {
				temp[i] = '0';
			}
			//입력된 문자열을 처음부터 끝까지 검사해가면서 
			int cnt = 0;
			for (int i = 0; i < input.length; i++) {
				//검사하는 위치의 비트가 초기화된 temp와 다르다면 
				if (input[i] != temp[i]) {
					cnt++;
					for (int j = i; j < input.length; j++) {
						temp[j] = input[i];
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
