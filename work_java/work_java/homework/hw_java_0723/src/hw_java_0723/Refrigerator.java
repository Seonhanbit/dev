package hw_java_0723;

public class Refrigerator extends Product {

	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}


	public Refrigerator() {
		
	}

	@Override
	public String toString() {
		return "Refrigerator [num=" + getNum() + ", name=" + getName() + ", price=" + getPrice() + ", su=" + getSu() + ", weight=" + weight + "]";
	}

	public Refrigerator(int num, String name, int price, int su, int weight) {
		super(num, name, price, su);
		this.weight = weight;
	}

}
