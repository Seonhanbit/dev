package product;

import java.util.ArrayList;

public class Manager {
	private static Manager man = new Manager();
	private ArrayList<Product> list = new ArrayList<>();

	private Manager() {

	}

	public static Manager getInstance() {
		return man;
	}

	public boolean addProduct(String name, String price, String sub) {
		list.add(new Product(list.size() + 1, name, price, sub));
		return true;
	}

	public int getListSize() {
		return list.size();
	}

	public ArrayList<Product> getList() {
		return list;
	}
}
