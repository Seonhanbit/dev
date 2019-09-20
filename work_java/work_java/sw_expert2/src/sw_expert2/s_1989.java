package sw_expert2;

import java.util.Scanner;

public class s_1989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			
			//가운데 글자를 출력
//			System.out.println(str.charAt(str.length()/2));
			// 가운데 글자를 기준으로 양쪽에 length()/2 만큼의 글자가 있음
			
//			for (int i = 0; i < str.length() / 2; i++) {
//				if (str.charAt(0+i) != str.charAt(str.length()-1 -i)) {
//					result =0;
//					break;
//				}
//			}

			char[] ch_arr = str.toCharArray();

			int result = 0;
			for (int i = 0; i < (ch_arr.length / 2); i++) {
				if (ch_arr[i] == ch_arr[(ch_arr.length - 1) - i]) {
					result++;
				}
			}

			if (result == (ch_arr.length / 2))
				System.out.println("#" + tc + " " + "1");
			else
				System.out.println("#" + tc + " " + "0");

		}

	}
}
