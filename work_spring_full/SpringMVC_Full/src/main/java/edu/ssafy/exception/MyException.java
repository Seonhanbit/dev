package edu.ssafy.exception;

public class MyException extends Exception{

	private static final long serialVersionUID = 1L;
	public MyException() {
		super("MyException");
	}
	public void trace() {
		this.toString();
	}
}
