package argorithm;

import java.io.Serializable;
import java.util.Scanner;

public class Stack implements Serializable{

	public static void main(String[] args) {
		// 스택에 저장될 자료를 담을 공간 준비 -> 1차원 배열
		int[] stack = new int[5];
		// 마지막에 삽입된 원소의 위치를 기억하는 변수, -1은 공백상태
		int top = -1;
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Push (입력 예 : 1 10)\n2. Pop (입력 예 : 2)\n0. 종료");
			int sel = sc.nextInt();
			
			if(sel ==0)
				break;
			else if(sel ==1) {
				//push
				int val = sc.nextInt();
				if(top<stack.length-1) {
					top++;
					stack[top] = val;
				}else {
					System.out.println("StackOverflowExcsption");
				}
			}else if(sel == 2) {
				//pop
				if(top>=0) {
				System.out.println(stack[top]);
				top--;}
				else {
					System.out.println("EmptyStackExcsption");
				}
			}
		}
	}

}
