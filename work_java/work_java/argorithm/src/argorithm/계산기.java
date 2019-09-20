package argorithm;

import java.util.Scanner;
import java.util.Stack;

public class 계산기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		// 후위표기식 계산하기
		// 스택에 넣을 자료형이 int이므로 integer 스택 준비하기
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			//피연산자 라면
			if(Character.isDigit(c)) {
				//스택에 푸쉬  int형으로 바꾸는법 아스키코드 1=49, 2=50, 0=48 빼면 값나옴
				stack.push(c - '0');
			}
			//연산자라면
			else if(c == '+' || c == '-' || c == '*'|| c == '/') {
				int num2 = stack.pop();
				int num1 = stack.pop();		
				if( c == '+')
					stack.push(num1 + num2);
				else if(c == '*')
					stack.push(num1 * num2);
				else if(c == '/')
					stack.push(num1 / num2);
				else if(c == '-')
					stack.push(num1 - num2);
				}
			}
		System.out.println(stack.pop());
	}
}
