package chat;

class MyThread implements Runnable{

	@Override
	public void run() {
		
		System.out.println("do it");
		
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		//스레드란? 명령처리 흐름
		System.out.println("Hello");
		Thread t = new Thread(new MyThread());
		t.start();
		
		System.out.println("world");

	}

}
