package edu.ssafy.chap08.two;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class BookMgrImpl implements IBookMgr {

	private ArrayList<Book> list;
	private static BookMgrImpl man = new BookMgrImpl();
	public static BookMgrImpl getInstace() {
		return man;
	}
	
	private BookMgrImpl() {
		list = new ArrayList<>();
	}

	@Override
	public void add(Book b) throws MyException {
		for(Book book : list) {
			if(book.getIsbn().equals(b.getIsbn())) {
				throw new MyException("중복데이터 입니다.");
			}
		}
		list.add(b);
	}

	@Override
	public void update(Book b) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getIsbn().equals(b.getIsbn())) {
				list.set(i, b);
			}
		}
	}

	@Override
	public void delete(String isbn) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				list.remove(i);
			}
		}
	}

	@Override
	public List<Book> search() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Book search(String isbn) throws MyException {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				return list.get(i);
			}
		}
		throw new MyException("데이터 없어용");
	}

	@Override
	public void send() throws UnknownHostException, IOException {
		//클라이언트 접속하기
		Socket s = new Socket("192.168.24.128", 7000);
		//서버한테 데이터 보내기 
		//클라이언트가 아웃풋 인풋 순서로 열때 서버는 인풋 아웃풋 순서로 열기
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
		oos.writeObject(list);
		oos.flush();
//		oos.close(); // 무한 돌릴때는 끊어버리면 안돼
		//닫으면 서버가 데이터를 보낼 수 없음 		
	}
}

