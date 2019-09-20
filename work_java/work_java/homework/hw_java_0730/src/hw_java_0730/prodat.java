package hw_java_0730;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class prodat extends Product {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Product[] p = new Product[10];
		p[0] = new TV(111, "나는 북북이", 20000, 30, 58);
		p[1] = new TV(222, "나는 거북이", 40000, 20, 70);
		p[2] = new TV(333, "나는 노랭이", 10000, 80, 20);
		p[3] = new TV(555, "티브이11", 10000, 10, 5);
		p[4] = new Refrigerator(999, "냉장고22", 60000, 20, 500);
		p[5] = new Refrigerator(101, "냉장고33", 50000, 50, 900);
		p[6] = new Refrigerator(202, "냉장고44", 12000, 10, 10);
		p[7] = new Refrigerator(303, "냉장고55", 5000, 100, 5);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		fos = new FileOutputStream("product.dat");
		oos = new ObjectOutputStream(fos);
		for (int i = 0; i < 8; i++) {
			oos.writeObject(p[i]);
		}
		oos.close();
		fos.close();
	}
}
