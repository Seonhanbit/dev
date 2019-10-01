package D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s_DP_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			list.add(arr[0]);
			for(int i=1; i<n; i++) {
				boolean bk = false;
				for(int j=0; j<list.size(); j++) {
					if(list.get(j)<arr[i]) {
						bk=true;
					}else {
						list.set(j, arr[i]);
						bk=false;
						break;
					}	
				}
				if(bk)
					list.add(arr[i]);
			}
			System.out.println(list);
			System.out.println("#"+tc+" "+list.size());
			
/*			 bw.write("#" + tc + " " + count);
	         bw.write("\n");
	         bw.flush();*/
		}
	}
}
