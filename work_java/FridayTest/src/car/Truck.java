package car;

public class Truck extends Car {
	private int seat;

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public Truck() {

	}

	public Truck(String num, String model, int price, int seat) {
		super(num, model, price);
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Truck [seat=" + seat + ", Num=" + getNum() + ", Model=" + getModel() + ", Price="
				+ getPrice() +  "]";
	}

}
