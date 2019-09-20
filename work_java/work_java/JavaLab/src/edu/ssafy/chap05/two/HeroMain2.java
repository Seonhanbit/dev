package edu.ssafy.chap05.two;

public class HeroMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroManager man = new HeroManager();
		man.addHero(new Ironman());
		man.addHero(new Spiderman());
		man.addHero(new 헐크());
		man.addHero(new Ironman());
		
		man.printHero();
		System.out.println("--------");
		man.delHero(new 헐크());
		
		man.printHero();
	}

}
