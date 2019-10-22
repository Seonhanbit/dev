package edu.ssafy.exception;

public class MyException extends Exception{
	public MyException() {
		super("MyException");
	}
	public void trace() {
		this.toString();
	}
}
