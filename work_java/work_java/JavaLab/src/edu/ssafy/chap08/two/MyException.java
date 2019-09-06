package edu.ssafy.chap08.two;

public class MyException extends Exception{
	public MyException() {
		super("나는 오류다");
	}
	
	public MyException(String exception) {
		super(exception);
	}
	
}
