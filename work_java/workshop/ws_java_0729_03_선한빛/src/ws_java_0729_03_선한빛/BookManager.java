package ws_java_0729_03_선한빛;

public class BookManager implements IBookMgr{

	private Book[] bArr;
	private int max = 10;
	private int index = 0;
	
	BookManager(){
		bArr = new Book[max];
	}
	
	public void addBook(Book b) {
		if(index < max) {
			bArr[index] = b;
			index++;
		}else {
			Book[] tmp = new Book[max*2];
			max = max*2;
			System.arraycopy(bArr, 0, tmp, 0, bArr.length);
			bArr = tmp;
			bArr[index] = b;
			index++;
		}
	}

	@Override
	public void search() {
		for(int i=0; i<index; i++) {
			System.out.println(bArr[i].toString());
		}
		
	}

	@Override
	public void searchIsbn(String isbn) {
		System.out.println(isbn + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (isbn.equals(bArr[i].getIsbn())) {
				System.out.println(bArr[i].toString());
			}
		}
		
	}

	@Override
	public void title(String title) {
		System.out.println(title + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (title == bArr[i].getTitle()) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	@Override
	public void book() {
		System.out.println("Book만으로 검색한 결과입니다.");
		for(int i=0; i<index; i++) {
			if(!(bArr[i] instanceof Magazine)) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	@Override
	public void magazine() {
		System.out.println("Magazine만으로 검색한 결과입니다.");
		for(int i=0; i<index; i++) {
			if(bArr[i] instanceof Magazine) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	@Override
	public void searchMag() {
		System.out.println("Magazine 중 올해 잡지만 검색한 결과입니다.");
		Magazine m = new Magazine();
		for(int i=0; i<index; i++) {
			if(bArr[i] instanceof Magazine) {
				m = (Magazine)bArr[i];
				if(m.getYear() == 2019)
				System.out.println(bArr[i].toString());
			}
		}
	}

	@Override
	public void 출판사(String publisher) {
		System.out.println(publisher + "으로 검색한 결과입니다.");
		for (int i = 0; i < index; i++) {
			if (publisher.equals(bArr[i].getPublisher())) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	@Override
	public void 가격(int price) {
		System.out.println(price + "보다 낮은 가격의 도서입니다.");
		for (int i = 0; i < index; i++) {
			if (bArr[i].getPrice() < price) {
				System.out.println(bArr[i].toString());
			}
		}
	}

	@Override
	public void 금액합() {
		System.out.println("저장된 모든 도서의 금액 합계 : ");
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += bArr[i].getPrice();
		}
		System.out.println(sum);
	}

	@Override
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
