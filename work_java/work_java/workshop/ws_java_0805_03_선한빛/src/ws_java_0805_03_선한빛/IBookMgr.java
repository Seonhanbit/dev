package ws_java_0805_03_선한빛;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public interface IBookMgr {
	void add(Book b);

	ArrayList<Book> search();

	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;

	void buy(String isbn, int quantity) throws ISBNNotFoundException;

	int getTotalAmount();

	void send() throws UnknownHostException, IOException;
}
