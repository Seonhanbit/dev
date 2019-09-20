package edu.ssafy.chap07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

public class IOTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 쓰기
		FileOutputStream fos = null;
//		BufferedOutputStream bos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("sample3.txt");
			dos = new DataOutputStream(new BufferedOutputStream(fos));
			dos.writeInt(256);
			dos.writeDouble(3.141592);
			dos.writeUTF("Hello ssafy");
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 읽기
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream("sample3.txt")));
			int a = dis.readInt();
			double b = dis.readDouble();
			String c = dis.readUTF();
			System.out.println(a + "," +b+ c);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
