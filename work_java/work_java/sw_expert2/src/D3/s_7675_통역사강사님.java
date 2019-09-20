package D3;

import java.util.Arrays;
import java.util.Scanner;

public class s_7675_통역사강사님 {

	static String[] str2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			// 문장의 갯수만큰 카운트 배열을 준비해두고. 각 칸에 각 문장에서의 이름의 갯수를 센다.
			int N = sc.nextInt(); // 문장의 갯수
			int[] cnt = new int[N];
			int idx = 0; // 현재 몇번째 줄인지.
			while (idx < N) {
				String word = sc.next();
				// 이 단어가 단어변 cnt 배열의 idx번쨰에 숫자를 세자.
				// 단어의 조건. 첫글자는 대문자. 나머지는 다 소문자.
				char last = word.charAt(word.length() - 1);
				if (last == '.' || last == '?' || last == '!') {
					if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
						boolean isName = true;
						for (int i = 1; i < word.length() - 1; i++) {
							if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
								// 여기 한번이라도 들어가면 이름이 아님.
								isName = false;
							}
						}
						if (isName)
							cnt[idx]++;
					}
					idx++;
					// 첫글자 대문자에 마지막 문자 빼고 나머지가 다 소문자면 ok
				} else {
					// 여기서는 레알로 첫글자 대문자에 나머지 다 소문자면 ok
					if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
						boolean isName = true;
						for (int i = 1; i < word.length(); i++) {
							if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
								// 여기 한번이라도 들어가면 이름이 아님.
								isName = false;
							}
						}
						if (isName)
							cnt[idx]++;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int c : cnt) {
				sb.append(c).append(" ");
			}
			System.out.println(sb.toString());
		}
	}
}
