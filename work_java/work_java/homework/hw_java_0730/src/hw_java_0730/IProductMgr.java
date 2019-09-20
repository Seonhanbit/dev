package hw_java_0730;

import java.io.IOException;
import java.util.ArrayList;

public interface IProductMgr {
	void add(Product p) throws DuplicateException;
	ArrayList<Product> search();
	void search(int num) throws CodeNotFoundException;
	void re400(int liter) throws ProductNotFoundException;
	void tv50(int inci) throws ProductNotFoundException;
	void open() throws IOException, ClassNotFoundException ;
	void close();
}
