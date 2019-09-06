package hw_java_0730;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProductServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ServerSocket ss = new ServerSocket(7000);
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			while (true) {
				System.out.println("서버는 기다리는중.....");
				Socket cli = ss.accept();

				ois = new ObjectInputStream(new BufferedInputStream(cli.getInputStream()));

				// 읽기
				ArrayList<Product> cus = (ArrayList<Product>) ois.readObject();
				System.out.println("product client로부터 날아온 문자열 : " + cus.toString()+"\n");

				oos = new ObjectOutputStream(new BufferedOutputStream(cli.getOutputStream()));
				oos.writeObject(cus);
				oos.flush();
			}
		} catch (IOException e) {
//		} finally {
//			oos.close();
//			ois.close();
//			ss.close();
//		}
		}

	}
}
