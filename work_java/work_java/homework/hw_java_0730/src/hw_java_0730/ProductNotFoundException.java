package hw_java_0730;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {

	}

	public ProductNotFoundException(String m) {
		System.out.println(m);
	}
}
