package ws_java_0805_03_선한빛;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		IBookMgr man = new BookMgrImpl();

		man.add(new Book("111", "나는책1", 20000, 20));
		man.add(new Book("222", "나는책2", 20000, 20));

		ArrayList<Book> tmp = new ArrayList<Book>();

		System.out.println("저장된 모든 도서 : ");
		tmp = man.search();
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i));
		}

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

		// Thread 상속받아 구현하기
//		BookClient bc = new BookClient();
//		bc.start();


		try {
			man.send();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
