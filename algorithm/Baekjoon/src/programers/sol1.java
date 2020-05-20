package programers;

import java.io.*;
import java.util.*;

public class sol1 {
	static String p,s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		p = br.readLine();
		s = br.readLine();

		int cnt = solution();
		
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
	
	public static int solution() {
		int answer = 0;
		int min = 0;
		int max = 0;
		for(int i=0; i<p.length(); i++) {
			int P = p.charAt(i)-'0';
			int S = s.charAt(i)-'0';
			if(P==S)
				continue;
			min = Math.min(P, S);
			max = Math.max(P, S);
			if(Math.abs(P-S)<Math.abs(10+min-max))
				answer += Math.abs(P-S);
			else
				answer += Math.abs(10+min-max);
		}
		return answer;
	}

}
