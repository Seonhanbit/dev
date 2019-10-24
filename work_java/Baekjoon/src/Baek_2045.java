import java.io.*;
import java.util.*;

public class Baek_2045 {
	static int res;
	static int[][] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr = new int[3][3];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<3; i++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum+=arr[i][j];
			}
			if(sum>max)
				max = sum;
		}
		
	}
}
