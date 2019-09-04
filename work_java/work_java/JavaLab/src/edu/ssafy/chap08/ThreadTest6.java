package edu.ssafy.chap08;

public class ThreadTest6 {

	public static void main(String[] args) {
		//Thread 만들기
		//1. Thread를 상속받아 run override
		//2. Runnable을 상속받는 클래스를 만들어 Thread에게 전달
		
		Thread th = new Thread() {
			public void run() {
				//this>>th 쓰레드
			};
		};
		
		th.start();
		//1.요기 this 못씀: 메인은 static 
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 2. this는 Runnable
				
			}
		});
		th1.start();

	}

}
