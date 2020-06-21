package next;

import java.io.*;
import java.util.*;

public class b3154 {
	static int N;
	static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine();
		String[] arr = str.split(":");
		if(Integer.parseInt(arr[0])<10)
			arr[0]="0"+arr[0];
		
	}

}
