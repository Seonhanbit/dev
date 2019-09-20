package edu.ssafy.chap09;

public class RamdaTest3 {
	
	public static void main(String[] args) {
		calc c = (a,b)->a*b;
		Printer p = s->System.out.println(s);
		
		p.print(c.cal(3, 5)+" ");
	}

}
