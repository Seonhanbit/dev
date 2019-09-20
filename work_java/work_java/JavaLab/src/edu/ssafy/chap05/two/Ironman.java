package edu.ssafy.chap05.two;

public class Ironman extends Hero {
	String name = "Ironman";
	
	public String getName() {
		return name;
	}
	//재정의
	public void superPower() {
		// TODO Auto-generated method stub
		System.out.println("아이언맨 슈퍼파워!");
	}
	
	//확장
	public void 똑똑해요() {
		System.out.println("아이언맨이 똑똑해요!");
	}
	public void fly() {
		System.out.println("아이언맨이 날아 다닙니다!");
	}

}
