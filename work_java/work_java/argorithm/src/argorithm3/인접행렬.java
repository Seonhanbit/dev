package argorithm3;

import java.util.*;

public class 인접행렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		int k = sc.nextInt();
		//가중치
		for(int i=0; i<k; i++) { 
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			arr[n1][n2] = 1;
			arr[n2][n1] = 1;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(arr[i][j]+" " );
			System.out.println();
		}
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1]=true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node+" ");
			for(int i=0; i<N+1; i++) {
				if(arr[node][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
