package edu.ssafy.chap08.two;

import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Dispatcher {
	private BookMgrImpl man;
	private Scanner scan;
	private int menu;

	public Dispatcher() {
		man = BookMgrImpl.getInstace();
		scan = new Scanner(System.in);
	}

	public void go() {
		while (true) {
			System.out.println("번호를 입력하세요~ \n 1.입력 , 2.조회, 3.send, 0. 종료");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("isbn title 가격 수량을 입력하세요.");
				String isbn = scan.next();
				String title = scan.next();
				int price = scan.nextInt();
				try {
					man.add(new Book(isbn, title, price));
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				List<Book> search = man.search();
				print(search);
				break;
			case 3:
				try {
					man.send();
					System.out.println("서버로 전송 성공");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				System.exit(0);;
				break;
			}
		}
	};

	private void print(List<Book> list) {
		for (Book book : list) {
			System.out.println(book.toString());
		}
	}

	public static void main(String[] args) {
		new Dispatcher().go();
	}
}

//Frame f = new Frame();
//TextField tf = new TextField();
//Button b = new Button("버튼");
//f.add(tf);
