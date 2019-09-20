package car;

public class Bus extends Car {
	private int ton;

	public int getTon() {
		return ton;
	}

	public void setTon(int ton) {
		this.ton = ton;
	}

	public Bus() {

	}

	public Bus(String num, String model, int price, int ton) {
		super(num, model, price);
		this.ton = ton;
	}

	@Override
	public String toString() {
		return "Bus [ton=" + ton + ", getTon()=" + getTon() + ", getNum()=" + getNum() + ", getModel()=" + getModel()
				+ ", getPrice()=" + getPrice() + "]";
	}
	
}
