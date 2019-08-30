package edu.ssafy.chap08;

public class ThreadTest1 extends Thread{
	
	@Override
	public void run() {
		test();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start...........");
				
//		test();
		
		ThreadTest1 th = new ThreadTest1();
		th.start();
		
		System.out.println("main end.............");
	}
	
	static void test() {
		System.out.println("test start......");
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("test end......");
	}

}
