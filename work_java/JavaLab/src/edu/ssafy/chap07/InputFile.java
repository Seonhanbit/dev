package edu.ssafy.chap07;

import java.io.*;

class InputFile {
	FileReader fis;

	public InputFile(String filename) throws FileNotFoundException, Exception {
		fis = new FileReader("data.txt");
		throw new Exception();
	}

	void readLine() {
		String s;
		BufferedReader buf = new BufferedReader(fis);
		try {
			while ((s = buf.readLine()) != null)
				System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] a) {
		InputFile inputFile;
		try {
			inputFile = new InputFile("data.txt");
			inputFile.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Program End...");
	}
}
