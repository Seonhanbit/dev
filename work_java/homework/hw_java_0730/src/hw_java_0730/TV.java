package hw_java_0730;

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
		return "TV [inci=" + inci + ", 상품 번호=" + getNum() + ", 상품 이름=" + getName() + ", 가격=" + getPrice()
				+ ", 수량=" + getSu() + "]";
	}
}
