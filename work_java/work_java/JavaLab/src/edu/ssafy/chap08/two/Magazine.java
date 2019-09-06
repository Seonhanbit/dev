package edu.ssafy.chap08.two;


public class Magazine extends Book{
	private int month;
	
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

	public Magazine(String isbn, String title, int price, int month) {
		super(isbn, title, price);
		this.month = month;
	}

	@Override
	public String toString() {
		return "Magazine [month=" + month + ", getIsbn()=" + getIsbn() + ", getTitle()=" + getTitle() + ", getPrice()="
				+ getPrice() + "]";
	}	
	
}

