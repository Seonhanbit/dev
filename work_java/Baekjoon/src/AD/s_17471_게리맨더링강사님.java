package AD;

import java.io.*;
import java.util.*;

public class s_17471_게리맨더링강사님 {
	static int N;// 선거구 수
	static int[] people; // 각 선거구별 유권자 수
	static int[][] near; // 선거구 간의 인접 정보
	static boolean[] sel; // 선거구를 true/false 두 집단으로 나눠보자
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		near = new int[N + 1][N + 1];
		sel = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++)
			people[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				near[i][a] = 1;
				near[a][i] = 1;
			}
		}
		powerset(1);
		for(int i=1; i<N/2; i++)
			combination(0,0,new int[i]);
		System.out.println(min==Integer.MAX_VALUE? -1: min);
	}

	static void powerset(int idx) {
		if (idx == N + 1) {
			// 각 마을 집단이 서로서로 모두 연결인지 검사해서 t/f리턴
			if (check()) {
				int sumA = 0;
				int sumB = 0;
				for(int i=1; i<=N; i++) {
					if(sel[i])
						sumA += people[i];
					else
						sumB += people[i];
				}
				min = Math.min(min, Math.abs(sumA-sumB));
			}
			return;
		}
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;
		powerset(idx + 1);
	}
	
	static void combination(int idx, int s_idx, int[] sel) {
		if(s_idx == sel.length) {
			//do something
			//게리맨더링.sel(위의 셀을 표현함)
			return;
		}
		if(idx==N+1)
			return;
		sel[s_idx] = idx;
		combination(idx+1, s_idx+1, sel);
		combination(idx+1, s_idx, sel);
	}

	static boolean check() {
		List<Integer> areaA = new ArrayList<>();
		List<Integer> areaB = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (sel[i])
				areaA.add(i);
			else
				areaB.add(i);
		}
		if(areaA.size() ==0 || areaB.size()==0)
			return false;

		boolean[] visited = new boolean[N + 1];
		// A마을 아무 지점이나 출발로, B마을 아무 지점이나 출발로
		// 각각 BFS, DFS를 통해 탐색하며 방문할때 true로 변경
		if (areaA.size() > 0) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(areaA.get(0));
			visited[areaA.get(0)] = true;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				for (int i = 1; i <= N; i++) {
					// sel[i]가 true면 A마을
					// A마을이면서, 인접경로가 존재하고, 아직 방문하지 않았다면 큐에 추가
					if (sel[i] && near[node][i] != 0 & !visited[i]) {
						visited[i] = true;
						queue.add(i);
					}
				}
			}
		}
		if (areaB.size() > 0) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(areaB.get(0));
			visited[areaB.get(0)] = true;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				for (int i = 1; i <= N; i++) {
					// sel[i]가 false면 B마을
					// A마을이면서, 인접경로가 존재하고, 아직 방문하지 않았다면 큐에 추가
					if (!sel[i] && near[node][i] != 0 & !visited[i]) {
						visited[i] = true;
						queue.add(i);
					}
				}
			}
		}
		//System.out.println(areaA);
		//System.out.println(areaB);
		// 양쪽 다 탐색 후 visited의 1번부터 N번까지 모두 true가 되어있다면 연결된 것
		for (int i = 1; i <= N; i++) {
			//System.out.println(visited[i]);
			if (!visited[i])
				return false;
		}
		return true;
	}
}
