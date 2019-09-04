package com.ssafy;

public class BookManager {

	protected Book[] bArr;
	protected int max = 10;
	protected int index = 0;

	public BookManager() {
		bArr = new Book[max];
	}

	// 데이터 입력
	public void addBook(Book b) {
		if (index < max) {
			bArr[index] = b;
			index++;
		} else {// 배열카피
			Book[] temp = new Book[max * 2]; // 주소값
			max *= 2;
			System.arraycopy(bArr, 0, temp, 0, bArr.length);
			bArr = temp;
			bArr[index] = b;
			index++;
		}
	}

	// 데이터 전체 검색
	public void search() {
		for (int i = 0; i < index; i++) {
			System.out.println(bArr[i].toString());
		}
	}

	// isbn
	public void searchIsbn(String isbn) {
		System.out.println(isbn + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (isbn.equals(bArr[i].getIsbn())) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	// title
	public void title(String title) {
		System.out.println(title + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (title.equals(bArr[i].getTitle())) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	// book
	public void book() {
		System.out.println("Book만으로 검색한 결과입니다.");
		for(int i=0; i<index; i++) {
			if(!(bArr[i] instanceof Book)) {
				System.out.println(bArr[i].toString());
			}
		}

	}

	// magazine
	public void magazine() {
		System.out.println("Magazine만으로 검색한 결과입니다.");
		for(int i=0; i<index; i++) {
			if(bArr[i] instanceof Magazine) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	// 출판사
	public void 출판사(String publisher) {
		System.out.println(publisher + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (publisher.equals(bArr[i].getPublisher())) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	// 가격
	public void 가격(int price) {
		System.out.println(price + "보다 낮은 가격의 도서입니다.");
		for (int i = 0; i < index; i++) {
			if (bArr[i].getPrice() < price) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	// 금액합
	public void 금액합() {
		System.out.println("저장된 모든 도서의 금액 합계 : ");
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += bArr[i].getPrice();
		}
		System.out.println(sum);
	}

	// 금액평균
	public void 금액평균() {
		System.out.println("저장된 모든 도서의 금액 평균 : ");
		int sum = 0;
		int aver = 0;
		for (int i = 0; i < index; i++) {
			sum += bArr[i].getPrice();
			aver = sum / index;
		}
		System.out.println(aver);
	}

}
