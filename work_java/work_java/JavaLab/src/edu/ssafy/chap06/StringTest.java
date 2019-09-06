package edu.ssafy.chap06;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		str = str + str2;

		if (str==str2) {
			System.out.println("같다");
		}if (str==str3) {
			System.out.println("같다");
		}

		if (str.equals(str2)) {

		}
		str.toString();

		String s = 34 + "a";
		System.out.println(s);

		System.out.println(str + 10);
		System.out.println(str + 7 + 10);

		System.out.println(7 + 10 + str);

		// a = 아스키 코드 97
		// 순차적 계산으로 107이 되고 문자열
		System.out.println(10 + 'a' + str);
		System.out.println(3.4 + "242");
		System.out.println(10 + "a");
	}

}
