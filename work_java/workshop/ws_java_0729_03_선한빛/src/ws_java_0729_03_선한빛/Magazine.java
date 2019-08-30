package ws_java_0729_03_선한빛;

public class Magazine extends Book {
	private int year;
	private int month;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year <= 2019 && year > 0) {
			this.year = year;
		} else {
			System.out.println("잘못된 년도입니다.");
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month < 13 && month > 0) {
			this.month = month;
		} else {
			System.out.println("잘못된 년도입니다.");
		}
	}

	public Magazine() {
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", Isbn()=" + getIsbn() + ", Title()=" + getTitle()
				+ ", Author=" + getAuthor() + ", Publisher()=" + getPublisher() + ", Price()=" + getPrice()
				+ ", Desc=" + getDesc() + "]";
	}

}
