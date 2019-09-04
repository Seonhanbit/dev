package sw_expert2;

import java.util.Scanner;
import java.util.Stack;

public class s_1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int n = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			String str1 = sc.next();

			int val = 1;
			for (int i = 0; i < n; i++) {
				char c = str1.charAt(i);
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.peek() != '(') {
						val = 0;
						break;
					} else if (stack.empty()) {
						val = 0;
						break;
					} else {
						stack.pop();
					}
				} else if (c == ']') {
					if (stack.peek() != '[') {
						val = 0;
						break;
					} else if (stack.empty()) {
						val = 0;
						break;
					} else {
						stack.pop();
					}
				} else if (c == '}') {
					if (stack.peek() != '{') {
						val = 0;
						break;
					} else if (stack.empty()) {
						val = 0;
						break;
					} else {
						stack.pop();
					}
				} else if (c == '>') {
					if (stack.peek() != '<') {
						val = 0;
						break;
					} else if (stack.empty()) {
						val = 0;
						break;
					} else {
						stack.pop();
					}
				}
			}
			System.out.println("#" + tc + " " + val);
		}
	}

}
