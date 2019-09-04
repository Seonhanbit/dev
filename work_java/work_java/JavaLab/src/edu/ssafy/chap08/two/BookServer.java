package edu.ssafy.chap08.two;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookServer {
	// 받아들일 서버 소켓 필요
	private ServerSocket ssock;
	private ArrayList<Socket> clients;

	public BookServer() throws IOException {
		ssock = new ServerSocket(7000);
		// 포트 번호 7000번 주기
		clients = new ArrayList<Socket>();
	}

	void go() throws IOException, ClassNotFoundException, Exception {
		// 서버 대기하라고 무한루프 돌려주기
		while (true) {
			System.out.println("서버는 대기중..........");
			Socket accept = ssock.accept();
			clients.add(accept);
			System.out.println(accept.getInetAddress().getHostAddress() + "님이 접속하였습니다.");
			System.out.println("현재 접속 중인 client 는 "+ clients.size()+"입니다");
			// 클라이언트가 먼저 아웃풋했으니까 인풋으로 열기
//			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(accept.getInputStream()));
//			ArrayList<Book> list = (ArrayList<Book>) ois.readObject();
//			// 콘솔에 프린트해주기(프린트 함수 이용)
//			print(list);

			// thread 객체 생성해서 불러주기 > run 메소드 실행하기
			new clientThread(accept).start();
		}
	}

	// 여러개의 client를 받기 위해 client를 응대하는 Thread 이용하기
	// 외부에서 부를일 없으니 private (클래스 안에 클래스)
	private class clientThread extends Thread {
		private Socket accept;

		// 소캣을 받는 생성자 만들기 > 계속 가지고 있어야하니까 맴버로 선언
		public clientThread(Socket accept) {
			this.accept = accept;
		}

		@Override
		public void run() {
			ObjectInputStream ois = null;
			// 파일에 쓰는 것 추가하기
			ObjectOutputStream oos = null;
			// 여러개 돌려야 하니까 무한 루프
			try {
				while (true) {
					ois = new ObjectInputStream(new BufferedInputStream(accept.getInputStream()));
					ArrayList<Book> list = (ArrayList<Book>) ois.readObject();
					// 콘솔에 프린트해주기(프린트 함수 이용)
					print(list);
					// 파일에 쓰는 것 추가하기
					oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data.ser")));
					oos.writeObject(list);
					oos.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					oos.close();
					ois.close();
					for (int i = 0; i < clients.size(); i++) {
						if(clients.get(i)==accept) {
							//주소비교 후 제거
							clients.remove(i);
							System.out.println(clients.get(i).getInetAddress().getHostAddress() + "님이 접속을 끊었습니다.");
						}
					}
					accept.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void print(List<Book> list) {
		for (Book book : list) {
			System.out.println(book.toString());
		}
	}

	public static void main(String[] args) {
		try {
			new BookServer().go();
			System.out.println("서버 실행 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
