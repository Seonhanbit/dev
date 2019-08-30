package edu.ssafy.chap05.two;

public class StaticTest {
	int i;
	static int si;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticTest st = new StaticTest();
		st.i = 10;
		st.si = 200;
		System.out.println(StaticTest.si);
		
		StaticTest st1 = new StaticTest();
		st1.i = 20;
		st1.si = 10;
		StaticTest.si = 100;
		
		
	}

}
