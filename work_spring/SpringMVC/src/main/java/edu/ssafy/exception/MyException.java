package edu.ssafy.exception;

public class MyException extends Exception{
	public MyException() {
		super("MyException");
	}
	public MyException(String msg) {
		super(msg);
	}
	public void trace() {
		this.toString();
	}
}
