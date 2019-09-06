package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ReceiverThread implements Runnable {
	private BufferedReader br;

	public ReceiverThread(BufferedReader br ) {
		this.br = br;
	}

	@Override
	public void run() {
		try {
			String msg = null;
			while ((msg = br.readLine()) !=null) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			
		}

	}
}
