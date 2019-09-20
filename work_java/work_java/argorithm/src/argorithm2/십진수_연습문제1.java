package argorithm2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 십진수_연습문제1 {
	static String str = "0000000111100000011000000111100110000110000111100111100111111001100111\n";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(str);
		String input = s.next();
		System.out.println(input.length());
		int start = 0;
		int end = 7;
		while (end <= input.length()) {
//			System.out.println(input.substring(start,end));
			String binary = input.substring(start, end);
			int num = 0;
			for (int i = 0; i < 7; i++) {
				// 1<<i 1,2,4,8,16,32,64
				num += (binary.charAt(7 - 1 - i) - '0') * (1 << i);
			}
			System.out.println(num);
			start += 7;
			end += 7;
		}
	}

}
