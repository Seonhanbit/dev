package edu.ssafy.chap07;

import java.util.Scanner;
import java.util.zip.DataFormatException;

import javax.xml.bind.DataBindingException;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int a = s.nextInt();
		int b = s.nextInt();
		int res = 0;

		try{
			res = div(a, b);
			System.out.println(100/res);
		}catch(ArithmeticException e ){
			System.out.println("ArithmeticException!");
		}catch(MyDataInputException e) {
			e.showError();
		}
		System.out.println("end");
	}

	static int div(int a, int b) throws ArithmeticException, MyDataInputException, DataBindingException{
		int res = 0;
		if(b==0) {
			throw new MyDataInputException("0을 입력하지 마세요");
		}
		res = a / b;
		return res;
	}
}
