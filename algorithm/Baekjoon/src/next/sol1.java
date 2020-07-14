package satreci_ex;

import java.io.*;
import java.util.*;

public class sol1 {
	
	//string을 n으로 끊기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//int n = Integer.parseInt(br.readLine());
		//int s = Integer.parseInt(br.readLine());
		
		//System.out.println(n/s);
		String str = br.readLine();
		char[] arr = str.toCharArray();
		int s = str.length();
		String ss = "";
		int cnt = 0;
		for(int i=0; i<s;i++) {
			ss +=arr[i];
			cnt++;
			if(cnt%2==0) {
				ss+="\n";
			}
		}
		System.out.println(ss);
	}
	
	public static int[] solution(int n, int s) {
        int[] answer = {};
        return answer;
    }
}
