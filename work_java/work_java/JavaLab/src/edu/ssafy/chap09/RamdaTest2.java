package edu.ssafy.chap09;

interface calc{
	int cal(int a, int b);
}

public class RamdaTest2 {

	public static void main(String[] args) {
		calc add = new calc() {

			@Override
			public int cal(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			};
		};

		System.out.println(add.cal(4,2));
		calc minus = new calc() {

			@Override
			public int cal(int a, int b) {
				// TODO Auto-generated method stub
				return a-b;
			};
		}; 
		System.out.println(minus.cal(4, 2));
		
		calc add2=(a,b)->{return a+b;};
		System.out.println(add2.cal(4, 3));
		
		calc add3=(a,b)->a+b;
		System.out.println(add3.cal(5, 3));
	}

}
