import java.net.*;
import java.io.*;

public class Sample_Code {

	// User and Game Server Information
	static final String NICKNAME = "Java Player";
	static final String HOST = "127.0.0.1";
	static final int PORT = 1447; // Do not modify

	// predefined variables(Do not modify these values)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 124;
	static final int NUMBER_OF_BALLS = 5;
	static final int[][] HOLES = { { 0, 0 }, { 130, 0 }, { 260, 0 }, { 0, 130 }, { 130, 130 }, { 260, 130 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];
		// 0번이 흰공 ,1번이 첫번쨰공 ...
		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = "9901/" + NICKNAME;
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play.");

			int k = 0;
			int r = 0;

			//int[] karr = new int[4];
			//karr[0] = 0;
			//karr[1] = 163;
			//karr[2] = 30;
			//karr[3] = 85;
			
			//int[] rarr = new int[3];
			//rarr[0] = 0;
			//rarr[1] = 15;
			//rarr[2] = 17;
			
			//int[] karr = new int[4];
			//karr[0] = 0;
			//karr[1] = 40;
			//karr[2] = 30;
			//karr[3] = 85;
			
			//int[] rarr = new int[4];
			//rarr[0] = 0;
			//rarr[1] = 14;
			//rarr[2] = 17;
			//rarr[3] = 8;
			
			
			int[] karr = new int[5];
			karr[0] = 0;
			karr[1] = 11;
			karr[2] = -74;
			karr[3] = 96;
			karr[4] = -6;
			
			int[] rarr = new int[5];
			rarr[0] = 0;
			rarr[1] = -20;
			rarr[2] = -62;
			rarr[3] = 5;
			rarr[4] = -55;

			while (socket != null) {

				bytes = new byte[1024];

				int readByteCount = is.read(bytes);
				recv_data = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				String[]	 split_data = recv_data.split("/");
				if (split_data[0].equals("9909"))
					break;

				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = new byte[1024];
					balls = new int[NUMBER_OF_BALLS][2];
					bytes = "9902/9902".getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}
				// 1
				//int angle = 50 + k;
				//int power = 55 + rarr[r];

				// 2
				// int angle = 105;
				// int power = 90;

				//3
				//int angle = 105 + karr[k];
				//int power = 90 + rarr[r];
				//k += 1;
				//r += 1;
				
				//4
				//int angle = 50 + karr[k];
				//int power = 55 + rarr[r];
				//k += 1;
				//r += 1;
				
				//5
				int angle = 89+ karr[k];
				int power = 100 + rarr[r];
				k += 1;
				r += 1;

				////////////////////////////////////////////////////////////////////
				// �־��� ����(balls)�� �������� �� ����(angle)�� ����(power)�� �����ϴ� �ڵ� �ۼ�
				//////////////////////////////////////////////////////////////////// //
				//////////////////////////////////////////////////////////////////

				String merged_data = angle + "/" + power;
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
