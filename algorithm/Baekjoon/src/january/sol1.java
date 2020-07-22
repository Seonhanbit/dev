package sk;

import java.io.*;
import java.util.*;

public class sol1 {

	public static void main(String[] args) {

	}

	public static String solution(int N) {
		String str = "";
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for(int i=0; i<N; i++) {
			str +=arr[i];
		}
		return str;
	}

}
