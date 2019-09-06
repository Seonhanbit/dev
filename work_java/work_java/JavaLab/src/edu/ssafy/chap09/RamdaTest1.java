package edu.ssafy.chap09;

interface Printer{
	void print(String str);
}

public class RamdaTest1 {

	public static void main(String[] args) {
		//Lagacy 방식
		Printer p = new Printer() {
			@Override
			public void print(String str) {
				System.out.println(str);
			}
		};
		p.print("HELLO");
		//Ramda expression 인자 1개 미구현 함수 1개
		Printer p2 = (String s)->{System.out.println(s);};
		p2.print("Ramda2");
		
		Printer p3 = (String s)->System.out.println(s);
		p3.print("Ramda3");
		
		Printer p4 = (s)->System.out.println(s);
		p4.print("Ramda4");
		
		Printer p5 = s->System.out.println(s);
		p5.print("Ramda5");
		
		//run에 매개변수 없으니까 공석()
		Runnable r = ()->System.out.println("Runnable");
		r.run();
		
		Thread th = new Thread(new Runnable() {
			public void run() {
				
			}});
		
		Thread th1 = new Thread(()->System.out.println("안녕"));
		th1.start();
	}
}



//class MyPrinter implements Printer{
//
//	@Override
//	public void print(String str) {
//		System.out.println(str);
//	}
//}