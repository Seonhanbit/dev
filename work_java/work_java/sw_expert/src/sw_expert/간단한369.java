package sw_expert;

import java.util.Scanner;

public class 간단한369 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int chkNum = 1; chkNum <= T; chkNum++) {
			// 문자열로 형변환
			String strCnt = String.valueOf(chkNum);
			// 형변환된 값의 길이 만큼 반복
			for (int j = 0; j < strCnt.length(); j++) {
				char chk = strCnt.charAt(j);
				if (chk == '3' || chk == '6' || chk == '9') {
					strCnt = strCnt.replace('3', '-');
					strCnt = strCnt.replace('6', '-');
					strCnt = strCnt.replace('9', '-');
				}
			}
			System.out.print(strCnt);
		}
	}
}
