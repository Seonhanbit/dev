package product;

public class Product {
	private int num;
	private String name;
	private String price;
	private String sub;

	public Product(int num, String name, String price, String sub) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.sub = sub;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", sub=" + sub + "]";
	}
}
