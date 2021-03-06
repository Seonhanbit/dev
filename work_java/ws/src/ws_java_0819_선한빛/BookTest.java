package ws_java_0819_선한빛;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookTest {
	int menu;
	Scanner s;
	BookDBO man;

	public BookTest() throws SQLException {
		s = new Scanner(System.in);
		man = new BookDBO();
	}

	private void printAllBooks(List<Book> list) {
		for (Book b : list) {
			System.out.println(b);
		}
	}

	public void go() {
		while (true) {
			System.out.println("1.입력 2.출력 3.검색 4.추가 5.수정 6.삭제 7.도서 개수 0.종료");
			menu = s.nextInt();
			switch (menu) {
			case 1:
				insert();
				list();
				break;
			case 2:
				list();
				break;
			case 3:
				search();
				break;
			case 4:
				insert1();
				list();
				break;
			case 5:
				update();
				break;
			case 6:
				delete();
				list();
				break;
			case 7:
				count();
				break;
			default:
				man.close();
				System.exit(0);
				break;
			}
		}
	}

	private void count() {
		System.out.println("현재 도서의 개수는 : " +man.count()+"입니다.");		
	}

	private void insert1() {
		man.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술 연구소", "자앤 출판사", 28000, "심화"));
	}

	private void delete() {
		System.out.println("삭제할 isbn를 입력하세요.");
		String isbn = s.next();
		man.deleteBook(isbn);
		;
	}

	private void update() {
		System.out.println("업데이트할 isbn를 입력하세요.");
		String isbn = s.next();
		System.out.println("업데이트할 title을 입력하세요.");
		String title = s.next();
		System.out.println("업데이트할 author을 입력하세요.");
		String author = s.next();
		System.out.println("업데이트할 publisher를 입력하세요.");
		String publisher = s.next();
		System.out.println("업데이트할 price을 입력하세요.");
		int price = s.nextInt();
		System.out.println("업데이트할 description을 입력하세요.");
		String description = s.next();
		man.updateBook(new Book(isbn, title, author, publisher, price, description));
	}

	private void search() {
		System.out.println("검색할 isbn을 입력하세요.");
		String isbn = s.next();
		System.out.println(man.findBook(isbn));
	}

	private void insert() {
		man.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술 연구소", "자앤 출판사", 23000, "기본"));
		man.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술 연구소", "자앤 출판사", 26000, "중급"));
		man.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술 연구소", "자앤 출판사", 30000, "실전"));
	}

	private void list() {
		List<Book> list = man.listBooks();
		for (Book b : list) {
			System.out.println(b);
		}
	}

	public static void main(String[] args) {
		try {
			new BookTest().go();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
