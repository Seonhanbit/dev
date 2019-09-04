package ws_java_0820_선한빛;

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
			System.out.println("1.author 추가, 2.book 수정, 3.검색, "
					+ "4.작가 이름 검색, 5.작가테이블 검색, 6.쿼리 0.종료");
			menu = s.nextInt();
			switch (menu) {
			case 1:
				insert();
				listAuthor();
				break;
			case 2:
				update();
				break;
			case 3:
				search();
				break;
			case 4:
				searchAuthor();
				break;
			case 5:
				System.out.println(man.printAuthor());
				break;
			case 6:
				query();
				break;
			default:
				man.close();
				System.exit(0);
				break;
			}
		}
	}

	private void query() {
		System.out.println(man.query());
	}

	private void searchAuthor() {
		System.out.println("검색할 작가를 입력하세요.");
		String name = s.next();
		System.out.println(man.findAuthor(name));
	}

	private void count() {
		System.out.println("현재 도서의 개수는 : " +man.count()+"입니다.");		
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
		System.out.println("업데이트할 publisher를 입력하세요.");
		String publisher = s.next();
		System.out.println("업데이트할 price을 입력하세요.");
		int price = s.nextInt();
		System.out.println("업데이트할 description을 입력하세요.");
		String description = s.next();
		System.out.println("업데이트할 authorno을 입력하세요.");
		int authorno = s.nextInt();
		man.updateBook(new Book(isbn, title, publisher, price, description, authorno));
	}

	private void search() {
		System.out.println(man.find());
	}

	private void insert() {
		man.insertAuthor(new Author(11, "김태희", "000-0000-0000"));
		man.insertAuthor(new Author(22, "원태희", "111-1111-1111"));
		man.insertAuthor(new Author(33, "최태희", "333-3333-3333"));
	}

	private void list() {
		List<Book> list = man.listBooks();
		for (Book b : list) {
			System.out.println(b);
		}
	}
	
	private void listAuthor() {
		List<Author> list = man.listAuthor();
		for (Author a : list) {
			System.out.println(a);
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
