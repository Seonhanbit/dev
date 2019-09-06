package ws_java_0730_03_선한빛;

import java.io.IOException;
import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) throws ClassNotFoundException, QuantityException, ISBNNotFoundException, IOException {
		// TODO Auto-generated method stub
		BookManager man = new BookManager();

		ArrayList<Book> tmp = new ArrayList<Book>();
		
		System.out.println("저장된 모든 도서 : ");
		tmp = man.search();
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i));
		}
		
//		for (Book book : man.search()) {
//			System.out.println(book);
//		}

		try {
			man.sell("222", 10);
		} catch (ISBNNotFoundException e) {
			e.showError();
		} catch (QuantityException e) {
			e.showError();
		}
		
		try {
			man.buy("333", 50);
		} catch (ISBNNotFoundException e) {
			e.showError();
		}
		
		System.out.println("저장된 모든 도서 : ");
		tmp = man.search();
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i));
		}

		
		System.out.println(man.getTotalAmount());

		try {
			man.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
