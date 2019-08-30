package com.ssafy;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookManager man = new BookManager();
		
		//데이터 입력 기능
		man.addBook(new Book("22222", "Javaro", "김하나", "Jaen.kr", 15000, "Java 기본 문법"));
		man.addBook(new Book("55555", "분석 설계", "소나무", "Jaen.kr", 30000, "SW 모델링"));
		man.addBook(new Book("44444", "분석 공학", "대나무", "Jren.kr", 45000, "분석 기법"));
		man.addBook(new Magazine("101", "프로 듀스", "나야나", "producor.kr", 100000, "덕후", 2019, 1));
		man.addBook(new Magazine("102", "매거진임 ", "너야너", "producer.or", 280000, "덕후", 2015, 2));
		man.addBook(new Magazine("103", "맥심 ", "누구야", "producer.or", 380000, "덕후", 2013, 8));
		
		Book b2 = new Book("66666", "Javaro", "입력테스트", "Jaen.kr", 15000, "Java 기본 문법");

		System.out.println("요구 사항을 입력하시오.");
		System.out.println("1. 데이터 입력 기능");
		System.out.println("2. 데이터 전체 검색 기능");
		System.out.println("3. Isbn으로 정보를 검색하는 기능");
		System.out.println("4. Title로 정보를 검색하는 기능");
		System.out.println("5. Book만 검색하는 기능");
		System.out.println("6. Managzine만 검색하는 기능");
		System.out.println("7. 출판사로 검색하는 기능");
		System.out.println("8. 가격으로 검색하는 기능");
		System.out.println("9. 저장된 모든 도서의 금액 합계를 구하는 기능");
		System.out.println("10. 저장된 모든 도서의 금액 평균을 구하는 기능");
		

		int T = sc.nextInt();

		switch (T) {
		case 1:
			man.addBook(b2);
			break;
		case 2:
			man.search();
			break;
		case 3:
			man.searchIsbn("22222");
			break;
		case 4:
			man.title("분석 설계");
			break;
		case 5:
			man.book();
			break;
		case 6:
			man.magazine();
			break;
		case 7:
			man.출판사("Jren.kr");
			break;
		case 8:
			man.가격(50000);
			break;
		case 9:
			man.금액합();
			break;
		case 10:
			man.금액평균();
			break;
		}

	}

}
