import java.io.*;
import java.util.*;

//계단오르기
//DP 어렵다...
public class Baek_2579 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine()); // 계단의 개수
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++)
			arr[i] =  Integer.parseInt(br.readLine());
		//먼저 첫번째 계단을 밟자
		dp[1] = arr[1];
		//2칸밖에 없을때는 2칸 모두 밟기
        if(N >= 2) dp[2] = dp[1]+arr[2];
     
        //
        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]); 
        }
		
		bw.append(dp[N] + "\n");
		bw.flush();
		bw.close();
	}
}
