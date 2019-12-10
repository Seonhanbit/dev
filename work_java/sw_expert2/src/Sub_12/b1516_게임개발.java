package Sub_12;

import java.io.*;
import java.util.*;

public class b1516_게임개발 {
	static int[] parent;
	static List<Integer>[] list;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		parent = new int[N + 1];
		int[] clock = new int[N + 1];
		int[] result = new int[N + 1];

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();

		for (int k = 1; k <= N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				cnt++;
				if (n == -1)
					break;
				if (cnt == 1) {
					clock[k] = n;
				} else {
					list[n].add(k);
					parent[k]++;
				}
			}
		}
		

		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(parent[i]==0) {
				queue.add(i);
				//해당 건물 짓는데 시간은 이만큼 들어
				result[i] = clock[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			//선수 건물이 모두 완료되어 지을 수 있게된 건물들을 큐에 추가
			for(int i=0; i<list[n].size(); i++) {
				if(--parent[list[n].get(i)]==0) {
					queue.add(list[n].get(i));
				}
				//건물이 지어지는 시간은 현지 지어진 시간으로부터 다음 건물 지어지는 시간 더한 것
				//이미 다른 경로로 도달했다면 둘 중 제일 큰 값 넣어주기
				result[list[n].get(i)] = Math.max(result[list[n].get(i)], result[n]+clock[list[n].get(i)]);
			}
		}

		for (int i = 1; i < N + 1; i++)
			bw.append(result[i] + "\n");

		bw.flush();
		bw.close();
	}
}
