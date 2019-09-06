package edu.ssafy.chap04;

public class PersonMain {

	public static void main(String[] args) {
		Person p = new Person("홍길동", 21, false, "장덕동");
		System.out.println(p.info());
//		p.name = "둘리";
//		p.age = 8;
//		p.gender = false;
//		p.addr = "쌍문동";
		
//		System.out.println(p.info());
//		
		Person p1 = new Person("둘리", 8, false, "쌍문동");
		System.out.println(p1.info());
//		p1.name = "고길동";
//		p1.age = 40;
//		p1.gender = false;
//		p1.addr = "쌍문동";
//		
		Person p2 = new Person();
		System.out.println(p2.info());

	}

}
