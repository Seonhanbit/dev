package hw_java_0723;

public class TV extends Product {
	private int inci;

	public int getInci() {
		return inci;
	}

	public void setInci(int inci) {
		this.inci = inci;
	}
	
	public TV() {
		
	}
	public TV(int num, String name, int price, int su, int inci) {
		super(num, name, price, su);
		this.inci = inci;
	}

	@Override
	public String toString() {
		return "TV [num=" + getNum() + ", name=" + getName() + ", price=" + getPrice() + ", su=" + getSu() + ", inci=" + inci + "]";
	}

	
}
