package edu.ssafy.chap08;

public class ThreadTest3 {

	public static void main(String[] args) {

		MyThread1 th1 = new MyThread1();
		MyThread2 th2 = new MyThread2();

		th2.start();
		th1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		th1.stop();
		th1.interrupt();
		System.out.println("main end.....");

	}

}

class MyThread1 extends Thread {
	@Override
	public void run() {

		try {
			for (int i = 0; i < 100; i++) {
				sleep(100);
				System.out.println("MyThread1 : " + i);
			}
		} catch (InterruptedException e) {

		} finally {

		}
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				sleep(70);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("MyThread2 : " + i);
		}
	}
}