package edu.ssafy.chap07;

public class MyDataInputException extends Exception {
	String errmg;

	public MyDataInputException() {

	}

	public MyDataInputException(String errmg) {
		this.errmg = errmg;
	}

	public void showError() {
		System.out.println(errmg);
	}
}
