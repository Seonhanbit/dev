package ws_java_0730_03_선한빛;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookManager implements IBookMgr {
	ArrayList<Book> books;

	public BookManager() throws ClassNotFoundException, IOException {
		books = new ArrayList<>();
		open();
	}

	@Override
	public void add(Book b) {
		// TODO Auto-generated method stub
		books.add(b);
//		String str = "20 ";
//		Integer.parseInt(str);
	}

	
	@Override
	public ArrayList<Book> search() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		// TODO Auto-generated method stub
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
			sum += books.get(i).getPrice()*books.get(i).getQuantity();
		}
		return sum;
	}

	@Override
	public void open() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("book.dat"));
			books = (ArrayList<Book>) ois.readObject();
//			while ((bc = (Book) ois.readObject()) != null) {
//				books.add(bc);
//			}
		} catch (IOException e) {
		}
	}

	@Override
	public void close() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream ois = null;
		ois = new ObjectOutputStream(new FileOutputStream("book.dat"));
		ois.writeObject(books);
		ois.close();
	}
}
