package edu.ssafy.chap06.two;

public class Bird extends Animal implements IFly{

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("새가 뛰어다닙니다");
	}
	
	public void fly() {
		System.out.println("새가 날아다닙니다");
	}

}
