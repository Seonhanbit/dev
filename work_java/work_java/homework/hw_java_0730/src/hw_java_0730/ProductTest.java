package hw_java_0730;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) throws CodeNotFoundException, ProductNotFoundException {
		// TODO Auto-generated method stub
		ProductMgrImpl man = ProductMgrImpl.getInstance();

		ArrayList<Product> tmp = new ArrayList<Product>();

		System.out.println("저장된 모든 상품 : ");
		tmp = man.search();
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i));
		}

		try {
			man.search(111);
		} catch (CodeNotFoundException e) {

		}
		
		try {
			man.re400(400);
		} catch (ProductNotFoundException e) {

		}
		
		try {
			man.tv50(50);
		} catch (ProductNotFoundException e) {

		}

//		man.th1.start();
		
		try {
			man.send();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}



