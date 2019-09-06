package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
		Book b = new Book("21424", "Javaro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		Book b1 = new Book("35355", "분석 설계", "소나무", "Jaen.kr", 30000, "SW 모델링");
		Book b2 = new Book("Gam j", "분석 공학", "대나무", "Jaen.kr", 45000, "분석 기법");
		Magazine m = new Magazine("101", "프로 듀스", "나야나", "producer.kr", 100000, "덕후", 2019, 1);
		Magazine m1 = new Magazine("102", "매거진임 ", "너야너", "producer.or", 280000, "덕후", 2029, 13);
		Magazine m2 = new Magazine();
		
		m.setYear(2029);
		m.setYear(2019);
		m.setMonth(7);
		m1.setMonth(2);
		m2.setAuthor("세번째");
		m2.setIsbn("103");
		m2.setTitle("타이틀   ");
		m2.setPublisher("korea.kee");
		m2.setPrice(112000);
		m2.setMonth(11);
		m2.setYear(2018);
		m2.setDesc("분석");
		
		System.out.println("***************도서 목록******************");
		System.out.println(b.toString());
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(m.toString());
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
		Book[] bArr = new Book[3];
		Magazine[] mArr = new Magazine[3];
		
		bArr[0]=b;
		bArr[1]=b1;
		bArr[2]=b2;
		for(int i=0; i<bArr.length; i++) {
			System.out.println(bArr[i].toString());
		}
		
	}

}
