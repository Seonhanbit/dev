package edu.ssafy.chap04;

/** class modeling, Person 정보 클래스*/
class Person {
	/** 이름*/
	String name ="홍길동";
	/** 나이*/
	int age;
	/** 성별*/
	boolean gender;
	/** 주소*/
	String addr;
	/** Constructor*/
	Person(){
//		this("홍길동", 21);
//		this.name
//		this.age
//		this.gender
//		this.addr
	}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	Person(String name, int age, boolean gender, String addr){
		System.out.println("생성자");
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.addr = addr;
		this.info();
	}
	/**정보 메소드*/
	String info() {
		String str = "name=" + name + "," + "age=" + age +"," + "gender=" + gender + "," + "addr=" + addr;
		return str;
	}
}