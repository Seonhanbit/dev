package hw_java_0730;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {

	private ArrayList<Product> pros = new ArrayList<>();

	private ProductMgrImpl() {
		try {
			this.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ProductMgrImpl Instance;

	public synchronized static ProductMgrImpl getInstance() {
		if (Instance == null)
			Instance = new ProductMgrImpl();
		return Instance;
	}

	@Override
	public void add(Product p) throws DuplicateException {
		// TODO Auto-generated method stub
		pros.add(p);
	}

	@Override
	public ArrayList<Product> search() {
		// TODO Auto-generated method stub
		return pros;
	}

	@Override
	public void search(int num) throws CodeNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(num + "상품을 검색합니다.");
		boolean ck = true;
		for (int i = 0; i < pros.size(); i++) {
			if (num == pros.get(i).getNum()) {
				ck = false;
				System.out.println(pros.get(i).toString());
			}
		}
		if (ck) {
			throw new CodeNotFoundException("해당 상품 번호가 존재하지 않습니다.");
		}
	}

	@Override
	public void re400(int liter) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(liter + "이상 상품을 검색합니다.");
		boolean ck = true;
		Refrigerator r = new Refrigerator();
		for (int i = 0; i < pros.size(); i++) {
			if (pros.get(i) instanceof Refrigerator) {
				r = (Refrigerator) pros.get(i);
				if (liter <= r.getLiter()) {
					ck = false;
					System.out.println(pros.get(i).toString());
				}
			}
		}
		if (ck) {
			throw new ProductNotFoundException("400 이상 상품이 존재하지 않습니다.");
		}
	}

	@Override
	public void tv50(int inci) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		TV t = new TV();
		boolean ck = true;
		System.out.println(inci + "인치 이상 상품 검색 :");
		for (int i = 0; i < pros.size(); i++) {
			if (pros.get(i) instanceof TV) {
				t = (TV) pros.get(i);
				if (t.getInci() > inci) {
					ck = false;
					System.out.println(pros.get(i).toString());
				}
			}
		}
		if (ck) {
			throw new ProductNotFoundException("400 이상 상품이 존재하지 않습니다.");
		}
	}

	@Override
	public void open() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("product.dat"));
			Product bc = null;
			while ((bc = (Product) ois.readObject()) != null) {
				pros.add(bc);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {

		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		ObjectOutputStream ois = null;
		try {
			ois = new ObjectOutputStream(new FileOutputStream("product.dat"));
			ois.writeObject(pros);
			ois.close();
			ois.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 0805 add
	public void send() throws UnknownHostException, IOException {
		Socket ser = new Socket("192.168.24.119", 7000);
		ser.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(ser.getOutputStream()));
		oos.writeObject(pros);
		oos.flush();
		oos.close();
	}

//	Thread th1 = new Thread(new Runnable() {
//		@Override
//		public void run() {
//			ObjectOutputStream ois = null;
//			try {
//				ois = new ObjectOutputStream(new FileOutputStream("product.dat"));
//				ois.writeObject(pros);
//				ois.close();
//				ois.flush();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	});

}
