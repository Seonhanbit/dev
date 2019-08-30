package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TcpClientTest {

	public static void main(String[] args) {
		try {
			// 소켓 객체를 생성함으로써 연결 요청을 보냄
			Socket socket = new Socket("192.168.24.120", 7001);
			// 서버랑 주고받는 형식은 같음
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
//			Map map = new HashMap();
			new Thread(new ReceiverThread(br)).start();
			Scanner sc = new Scanner(System.in);
			System.out.println("닉네임을 입력하세요.");
			String str = sc.next();

			while (true) {
				System.out.println("문자열을 입력하세요.");
				bw.write(str+":"+ sc.nextLine()+ "\n");
				bw.flush();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
//			System.out.println("언노운호스트");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			System.out.println("아이오");
			e.printStackTrace();
		}

	}

}
