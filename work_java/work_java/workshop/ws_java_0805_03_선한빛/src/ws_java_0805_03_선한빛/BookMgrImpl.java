package ws_java_0805_03_선한빛;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {

	ArrayList<Book> books = new ArrayList<>();

	public BookMgrImpl() {

	}

	@Override
	public void add(Book b) {
		books.add(b);
	}

	@Override
	public ArrayList<Book> search() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		System.out.println(isbn + "를 판매합니다.");
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			cnt++;
			if (isbn.equals(books.get(i).getIsbn())) {
				int a = books.get(i).getQuantity();
				if (a - 1 < 0) {
					throw new QuantityException("해당 도서를  판매할 수 없습니다.");
				}
				books.get(i).setQuantity(books.get(i).getQuantity() - quantity);
				break;
			}
		}
		if (cnt == books.size()) {
			throw new ISBNNotFoundException("존재하지 않습니다.");
		}

	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(isbn + "를 구매합니다.");
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			cnt++;
			if (isbn.equals(books.get(i).getIsbn())) {
				books.get(i).setQuantity(books.get(i).getQuantity() + quantity);
				break;
			}
		}
		if (cnt == books.size()) {
			throw new ISBNNotFoundException("존재하지 않습니다.");
		}
	}

	@Override
	public int getTotalAmount() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice() * books.get(i).getQuantity();
		}
		return sum;
	}

	@Override
	public void send() throws UnknownHostException, IOException {
		Socket ser = new Socket("192.168.24.119", 7000);
		ser.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(ser.getOutputStream()));		
		oos.writeObject(books);
		oos.flush();
		oos.close();
	}
}

//class BookClient extends Thread {
//	@Override
//	public void run() {
//		BookMgrImpl man = new BookMgrImpl();
//		man.search();
//	}
//}
