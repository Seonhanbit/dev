package toss;

import java.io.*;
import java.util.*;

public class pre {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int input = Integer.parseInt(br.readLine());
		if(input%2==0)
			bw.append("even");
		else
			bw.append("odd");
		bw.flush();
		bw.close();
	}

}
