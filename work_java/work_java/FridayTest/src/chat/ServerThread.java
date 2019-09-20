package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread implements Runnable{
	//클라이언트 갯수만큼 writer필요하니까 배열로 만들어주기
	//전부 다 내보내야해서 static writer
	static List<BufferedWriter> bwlist = new ArrayList<BufferedWriter>();
	BufferedReader br; //자신이 읽기를 수행할 br
	Socket ss;
	
	public ServerThread(BufferedReader br, Socket ss) {
		this.br = br;
		this.ss = ss;
	}

	@Override
	public void run() {
		try {
			String msg = null;
			while ((msg = br.readLine()) !=null) {
				System.out.println(msg);
				for(BufferedWriter bw : bwlist) {
					bw.write(msg+"\n");
					bw.flush();
				}
			}
		} catch (IOException e) {
				System.out.println("["+ ss.getInetAddress()+"]"+"님이 나갔습니다.");
		}
		
	}

}
