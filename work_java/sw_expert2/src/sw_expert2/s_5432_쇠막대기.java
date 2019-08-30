package sw_expert2;

import java.util.Scanner;

public class s_5432_쇠막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();

			char[] arr = str.toCharArray();

			int val = 0;
			int cnt = 0;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == ')' && arr[i - 1] == '(') {
					cnt += val;
				} else if (arr[i] == '(' && arr[i - 1] == ')') {
					continue;
				} else if (arr[i - 1] == '(') {
					val += 1;
				} else if (arr[i - 1] == ')') {
					cnt++;
					val--;
				}
			}

			// 다시 풀어보기(강사님)
			int result = 0;
			int stick =0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					char next_char = str.charAt(i + 1);
					if (next_char == '(') {
						// i위치에서 막대기 시작
						stick++;
					} else if (next_char == ')') {
						// i위치에서 레이저 떨어짐
					}
				} else if (c == ')') {
					char pre_char = str.charAt(i - 1);
					if (pre_char == '(') {
						// i위치에서 레이저 떨어짐
						result += stick;
					} else if (pre_char == ')') {
						// i위치에서 막대기 끝남
						stick++;
						result--;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
