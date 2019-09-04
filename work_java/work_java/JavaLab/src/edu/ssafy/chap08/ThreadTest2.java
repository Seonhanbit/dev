package edu.ssafy.chap08;

public class ThreadTest2 extends Thread{
	public ThreadTest2(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(" " + i+ Thread.currentThread());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start...........");
		
		ThreadTest2 tt = new ThreadTest2("Thread1");
		ThreadTest2 tt2 = new ThreadTest2("Thread2");
		
		tt.start();
		tt2.start();
		
		System.out.println("main end.............");
	}

}
