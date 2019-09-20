package edu.ssafy.chap07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("hello.txt");
		//1바이트 처리
		FileInputStream fis = new FileInputStream(f);
		int a=0;
		while((a=fis.read()) != -1) {
			System.out.print((char)a);
		}
		
		System.out.println("----");
		//2바이트 처리 (속도 1바이트보다 느림)
		FileReader fr = new FileReader(f);
		while((a=fr.read()) != -1) {
			System.out.print((char)a);
		}
		fis.close();
		fr.close();
	}

}
