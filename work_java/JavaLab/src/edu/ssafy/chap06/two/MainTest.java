package edu.ssafy.chap06.two;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird b = new Bird();
		Frog f = new Frog();
		Human h = new Human();
		Lion l = new Lion();
		Superman s = new Superman();
		
		towalk(b);
		towalk(f);
		towalk(h);
		towalk(l);
		towalk(s);
		
		tofly(s);
		tofly(b);
		
		
	}
	public static void tofly(IFly f) {
		f.fly();
	}
	
	public static void towalk(Animal a) {
		a.walk();
	}

}
