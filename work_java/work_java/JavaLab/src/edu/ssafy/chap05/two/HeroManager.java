package edu.ssafy.chap05.two;

public class HeroManager {
	
	private Hero[] heros;
	private int max =10;
	private int index =0;
	
	public HeroManager() {
		heros = new Hero[max];
	}
	
	public void addHero(Hero h) {
		if (index < max) {
			heros[index] = h;
			index++;
		}else {//배열카피
			Hero[] temp = new Hero[max*2]; //주소값
			max *=2;
			System.arraycopy(heros, 0, temp, 0, heros.length);
			heros = temp;
			heros[index] = h;
			index++;
		}
	}
	public void modiHero(Hero h) {
		for(int i=0; i<index; i++) {
			if(heros[i].name == h.name) {
				heros[i]=h;
			}
		}
	}
	public void delHero(Hero h) {
		for(int i=0; i<index; i++) {
			if(heros[i].getName() == h.getName()) {
				heros[i]= heros[index-1];
				index--;
			}
		}
	}
	public void printHero() {
		for(int i=0; i <index;i++) {
			heros[i].superPower();
		}
	}
}
