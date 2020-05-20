import java.io.*;
import java.util.*;

public class Main {	
	static int N, M;
	static long res = 0;
	static int[] arr, dept, answer;
	static Queue<Integer> queue = new LinkedList<Integer>();
/*
5 2
2 3 0 3 2
3 2
2 5
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dept = new int[N + 1];
		answer = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		int a = 0;
		for (int i = 1; i <= N; i++) {
			a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			dept[a]++;
		}

		for (int i = 1; i <= N; i++) {
			if (dept[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			if (tmp == 0)
				break;

			a = arr[tmp];
			dept[a]--;
			
			if (dept[a] == 0)
				queue.add(a);
			
			answer[a] += (answer[tmp] + 1);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			res += (answer[Integer.parseInt(st.nextToken())] - answer[Integer.parseInt(st.nextToken())]);
		}
		bw.append(String.valueOf(res));
		bw.flush();
		bw.close();
	}
}
