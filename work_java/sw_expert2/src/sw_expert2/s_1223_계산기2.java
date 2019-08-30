package sw_expert2;

import java.util.Scanner;
import java.util.Stack;

public class s_1223_계산기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1 ; tc <=10; tc++) {
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			Stack<Integer> stack2 = new Stack<>();
			
			int n = sc.nextInt();
			String str = sc.next();
			//후위 표기식 만들기
			for(int i =0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if(Character.isDigit(c)) {
					sb.append(c);
				}
				
				else if( c == '+') {
					while (!stack.empty()) {
						sb.append(stack.pop());
					}
					stack.push(c);
				}
				
				else if (c == '*') {
					while (!stack.empty() && stack.peek() != '+') {
						sb.append(stack.pop());
					}
					stack.push(c);
				}
			}
			while(!stack.empty()) {
				sb.append(stack.pop());
			}
			
			//숫자를 스택에 넣어서 다시 연산하기
			for(int i =0; i<sb.length(); i++) {
				char c = sb.charAt(i);
				
				if(Character.isDigit(c)) {
					stack2.push(c-'0');
				}
				
				else if(c == '+' ||c == '*') {
					int num2 = stack2.pop();
					int num1 = stack2.pop();
					if( c=='+') {
						stack2.push(num1+num2);
					}else if ( c=='*') {
						stack2.push(num1*num2);
					}
				}
			}
			
			int res = stack2.pop();
			System.out.println("#" + tc+ " " +res);
			
			res=0;
		}
	}

}
