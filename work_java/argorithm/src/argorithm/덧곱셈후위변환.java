package argorithm;

import java.util.Stack;

public class 덧곱셈후위변환 {

	public static void main(String[] args) {

		String str = "2+4*7*3+2";

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
//				System.out.print(c);
				sb.append(c);
			} else if (c == '+') {
				// stack 에 있는거 다 빼서 출력하고 푸쉬하기
				while (!stack.empty()) {
//					System.out.print(stack.pop());
					sb.append(stack.pop());
				}
				stack.push(c);
			} else if (c == '*') {
				// 맨 위가 덧셈이거나 빌 때까지 다 빼서 출력하고 푸쉬
				while (!stack.empty() && stack.peek() != '+') {
//					System.out.print(stack.pop());
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while (!stack.empty()) {
//			System.out.print(stack.pop());
			sb.append(stack.pop());
		}System.out.println(sb.toString());
	}
}
