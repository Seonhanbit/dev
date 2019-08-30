package ws_java_0729_03_선한빛;

public interface IBookMgr {
	void addBook(Book b);
	void search();
	void searchIsbn(String isbn);
	void title(String title);
	void book();
	void magazine();
	void searchMag();
	void 출판사(String publisher);
	void 가격(int price);
	void 금액합();
	void 금액평균();
}
