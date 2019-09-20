package argorithm;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class 문자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "Hello World 0_0, Welcome to hell 8_8";
//		//문자의 배열로 변환
//		char[] ch_arr = str.toCharArray();
//		
//		
//		for(int i=0; i< str.length(); i++) {
//			char c = str.charAt(i);
//			if(Character.isDigit(c))
//				System.out.println(c + "숫자입니다.");
//		}

		System.out.println("===============");

		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		String str1 = sc.next();

		for (int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.empty()) {
					System.out.println("wkwfwf잘못된 괄호입니다.");
				} else {
					stack.pop();
				}
			}
		}
		if (stack.empty())
			System.out.println("정상적인 괄호입니다.");
		else
			System.out.println("잘못된 괄호입니다.");

	}

}
