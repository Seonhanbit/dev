package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s_8959_ox퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int sum=0, cnt = 0;
			String str = br.readLine();
			char ck = 'X';
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)!=ck) {
					cnt++;
				}else {
					cnt=0;
				}
				sum+=cnt;
			}			
			System.out.println(sum);
		}

	}

}
