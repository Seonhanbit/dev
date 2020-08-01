package toss;

import java.io.*;
import java.util.*;

public class t_sol1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] input = br.readLine().toCharArray();
		boolean flag = true;
		int cnt = 0;
		int ncnt = 0;
		for (int i = 0; i < input.length; i++) {
			int val = input[i] - '0';
			if (val != 1 || val != 2)
				flag = false;
			if (val == 1)
				cnt++;
			if (cnt > 0 && val == 2)
				ncnt++;
			if (ncnt > 0 && val == 1)
				cnt = 0;
			if (ncnt > 0 && val == 2)
				ncnt = 0;
			if (cnt > 0 && val == 1)
				flag = false;
			if (cnt > 0 && val == 2)
				flag = true;
		}
		if (flag)
			bw.append("true");
		else
			bw.append("false");

		bw.flush();
		bw.close();
	}
}
