package edu.ssafy.model;

public class Calc {
	int op1;
	int op2;
	int sum;
	public Calc() {}
	public Calc(int op1, int op2, int sum) {
		this.op1=op1;
		this.op2=op2;
		this.sum=sum;
	}
	public int getOp1() {
		return op1;
	}
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	public int getOp2() {
		return op2;
	}
	public void setOp2(int op2) {
		this.op2 = op2;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
