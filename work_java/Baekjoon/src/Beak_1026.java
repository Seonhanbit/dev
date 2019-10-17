import java.io.*;
import java.util.*;

public class Beak_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		// 뒤로 정렬을 어떻게 할지 생각해보자...우선 일반 정렬
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		// arr2는 큰것 부터 곱해야지 제일 작은 수가 나온다!
		// 따라서 arr2의 인자값은 인덱스가 끝인 N-1부터 시작
		int a = N - 1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr1[i] * arr2[a];
			a--; //한개씩 줄여주면서 0까지 가기
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}
