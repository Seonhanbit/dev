package edu.ssafy.chap06;

public class MainTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AbstractTest a = new AbstractTest();
//		a.show();
		
		AbstractTest s = new Sub();
		s.show();
		
		AbstractTest s2 = new Sub();
		s2.show();
		
		AbstractTest[] arr= new AbstractTest[2];
		arr[0] = s;
		arr[1] = s2;
		
		toShow(s);
		toShow(s2);
		
	}
	
	static void toShow(AbstractTest at) {
		at.show();
	}

}
