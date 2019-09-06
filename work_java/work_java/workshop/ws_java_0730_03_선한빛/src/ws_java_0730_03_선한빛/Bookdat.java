package ws_java_0730_03_선한빛;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Bookdat extends Book {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Book[] b = new Book[10];
		b[0] = new Book("111", "나는 북북이", 20000, 30);
		b[1] = new Book("222", "나는 거북이", 40000, 20);
		b[2] = new Book("333", "나는 노랭이", 10000, 80);
		b[3] = new Magazine("555", "잡지11", 10000, 10, 5);
		b[4] = new Magazine("999", "잡지22", 60000, 20, 7);
		b[5] = new Magazine("101", "잡지33", 50000, 50, 9);
		b[6] = new Magazine("202", "잡지44", 12000, 10, 10);
		b[7] = new Magazine("303", "잡지55", 5000, 100, 5);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		fos = new FileOutputStream("book.dat");
		oos = new ObjectOutputStream(fos);
		for (int i = 0; i < 8; i++) {
			oos.writeObject(b[i]);
		}
		oos.close();
		fos.close();
	}
}
