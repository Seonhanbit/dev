package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TcpServer {

	public static void main(String[] args) {

		try {
			// port를 지정해서 ServerSocket을 생성하고 accept 대기
			ServerSocket serverSocket = new ServerSocket(7001);

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+"]"+"님이 들어왔습니다.");
				ArrayList<Socket> list = new ArrayList<Socket>();
				list.add(socket);
				// socket 객체로부터 입출력 스트림을 얻어서 원하는 형태로 가공
				// 버퍼드는 문자열 받는 애 OutputStreamWriter으로 바이트 형식인 socket.getOutputStream()를 변경해주는것
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				ServerThread.bwlist.add(bw);
				new Thread(new ServerThread(br, socket)).start();
			}

//			System.out.println("서버는 대기중");
//			// 클라이언트가 연결되면 안녕하세요 라고 전달할거고
//			// 그 다음에 클라이언트가 보내는 메세지를 개행까지 읽어서 출력
//			bw.write("Hello java\n");
//			bw.flush();
////			while (true) {
////			System.out.println(br.readLine());
////			}
//			Thread rc = new Thread(new ReceiverThread(br));
//			rc.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
