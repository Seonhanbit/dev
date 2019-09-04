package ws_java_0730_03_선한빛;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IBookMgr {
	void add(Book b);
	ArrayList<Book> search();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	void open() throws ClassNotFoundException, IOException;
	void close() throws FileNotFoundException, IOException, ClassNotFoundException;
}
