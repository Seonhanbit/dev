package edu.ssafy.chap08;

class MyRunnalbe implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}

public class ThreadTest5 {

	public static void main(String[] args) {
		System.out.println("main start..........");
		MyRunnalbe r = new MyRunnalbe();
		Thread th = new Thread(r);
		th.start();
		System.out.println("main end.............");

	}

}
