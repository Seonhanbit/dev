package hw_java_0730;

public class Refrigerator extends Product{
	private int liter;

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	public Refrigerator() {

	}
	public Refrigerator(int num, String name, int price, int su, int liter) {
		super(num, name, price, su);
		this.liter = liter;
	}

	@Override
	public String toString() {
		return "Refrigerator [liter=" + liter + ", 상품 번호=" + getNum() + ", 상품 이름=" + getName() + ", 가격="
				+ getPrice() + ", 수량=" + getSu() + "]";
	}
}
