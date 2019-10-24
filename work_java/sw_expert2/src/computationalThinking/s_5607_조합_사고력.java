package computationalThinking;

import java.io.*;
import java.util.*;

public class s_5607_조합_사고력 {
	static int n, r;
	// 고정된 p값
	static final int p = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// ****나머지 연산은 나머지만 곱해주면 해당 값이 똑같아****
		// 계속 펙토리얼은 쓸거니까 미리 배열에 지정해두자.
		long[] arr = new long[1000001];
		// 1!=1 넣어주기
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			// r!값은 너무 크니까 미리 %p해줘서 나머지를 구해서 넣어주기
			arr[i] = arr[i - 1] * i % p;
		}
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			// n!((n-r)!r!)^p-2 %p를 해보자!!!!!
			// n! == arr[n]
			// ((n-r)!r!)^p-2 == function(arr[n - r] * arr[r] % p, p - 2)
			long result = arr[n] * function(arr[n - r] * arr[r] % p, p - 2) % p;
			bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(result)).append("\n");
			bw.flush();
		}
		bw.close();
	}

	// 지수 승 구하기
	static long function(long base, int ex) {
		// 1승은 자기자신이니까 리턴
		if (ex == 1)
			return base;
		// 분할정복 하기 : 미리 절반 지수승을 변수에 저장해두기
		long res = function(base, ex / 2);
		
		if (ex % 2 == 1) {
			// 홀수라면
			// (절반지수+절반지수)로만 끝나는게 아니라 
			// 홀수니까 베이스 한개 더 곱해주기 (ex.5라면 2+2+1(베이스))
			// ****나머지 연산은 나머지만 곱해주면 해당 값이 똑같아****
			return res * res % p * base % p;
		}else {
			// 짝수라면
			// 절반과 절반을 곱해주는 나머지 값은 똑같아
			// 나머지를 곱해주면 연산이 끝남
			return res * res % p;
		}
	}

}
