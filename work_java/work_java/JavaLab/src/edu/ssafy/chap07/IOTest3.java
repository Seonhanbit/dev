package edu.ssafy.chap07;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOTest3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("sample2.txt");
		//모아서 써서 속도 빠름 바이트 배열
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String s = "Hello ssafy";
		bos.write(s.getBytes());
		
		//writer로 변형하기
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		//속도 향상 시키기 
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("Hello ssafy too");
		bw.flush();
		bw.close();
		
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("sample2.txt")));
		bw2.write("Hello ssafy three");
		bw2.flush();
		bw2.close();
		
//		FileInputStream fis = new FileInputStream("sample2.txt");
//		InputStreamReader isr = new InputStreamReader(fis);
		//한번에 쓰기
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("sample2.txt")));
		String sam;
		while((sam = br.readLine()) != null) {
			System.out.println(sam);
		}
		br.close();
	}

}
