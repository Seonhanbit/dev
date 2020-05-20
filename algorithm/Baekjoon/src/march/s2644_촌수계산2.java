package march;

import java.io.*;
import java.util.*;

public class s2644_촌수계산2 {
	static int N, num1, num2, n;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		int[] parents = new int[N + 1];
		visited = new boolean[N + 1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			parents[b] = a; //부모 저장
		}
		//사람번호, 촌수
		HashMap<Integer, Integer> hm = new HashMap<>();
		int val= 0; //촌수
		//num1의 조상으로 올라가면서 촌수를 기록
		while(num1!=0) {
			hm.put(num1, val++);
			num1 = parents[num1];//부모 값을 넣기
		}
		//num2의 조상으로 올라가면서 num1과 공통 조상이 있는지 검사(첫번째 조상 검사)
		val= 0; //촌수
		//num2의 조상으로 올라가면서 촌수를 기록
		while(num2!=0) {
			//공통 조상 검사하기
			if(hm.containsKey(num2)) {
				System.out.println(hm.get(num2) + val); //num1이 온 거리 + 현재 num2가 간 거리
				return;
			}
			val++;
			num2 = parents[num2];//부모 값을 넣기
		}
		System.out.println(-1);
	}

}
