package edu.ssafy.chap05.two;

public class HeroMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hero[] h = new Hero[3];
		h[0] = new 헐크();
		h[1] = new Spiderman();
		h[2] = new Ironman();
	
		for(int i=0; i<h.length; i++) {
			h[i].superPower();
			if(h[i] instanceof 헐크) {
				헐크 a = (헐크)h[i]; 
				a.성질();
			}else if(h[i] instanceof Spiderman) {
				Spiderman s =(Spiderman)h[i];
				s.착하다();
			}else if(h[i] instanceof Ironman) {
				Ironman iron = (Ironman)h[i];
				iron.똑똑해요();
			}
		}
	
	}

}
