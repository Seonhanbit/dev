package AD;

import java.io.*;
import java.util.*;

public class s_16235_나무재테크 {
	static int N, M, K;
	static int[][] arr;
	static int[][] A;
	static PriorityQueue<tree> list; //모든 나무가 들어있는 공간
	static Queue<tree> live; //봄에 산 나무 저장하는 것
	static Queue<tree> dead; //봄에 죽는 나무가 들어있을 큐 (여름에 실행할 것)
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	static boolean range(int x, int y) {
		return x >= 1 && x < N+1 && y >= 1 && y < N+1;
	}

	static class tree implements Comparable<tree> {
		int x;
		int y;
		int age;

		tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		// 봄에 하나의 칸에 여러개의 나무가 있다면 나이가 어린애부터 먹으니까 정렬
		@Override
		public int compareTo(tree o) {
			if(this.age > o.age)
				return 1;
			else if(this.age < o.age)
				return -1;
			else
				return 0;
		}

		@Override
		public String toString() {
			return "tree [x=" + x + ", y=" + y + ", age=" + age + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅 N*N
		M = Integer.parseInt(st.nextToken()); // 나무 수
		K = Integer.parseInt(st.nextToken()); // K년 후?
		arr = new int[N + 1][N + 1];
		A = new int[N + 1][N + 1];
		list = new PriorityQueue<>();
		live = new LinkedList<>();
		dead = new LinkedList<>();

		for (int i = 1; i < N + 1; i++)
			Arrays.fill(arr[i], 5); // 초기 양분은 5로 시작
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		// K년 만큼 돌아보자
		for (int k = 0; k < K; k++) {
			spring();
			summer();
			fall();
			winter();
		}

		int sum = list.size();
		bw.write(sum + "\n");
		bw.flush();
		bw.close();

	}

	static void spring() {
		while(!list.isEmpty()) {
			tree t = list.poll();
			if(arr[t.x][t.y]<t.age)
				dead.add(new tree(t.x,t.y,t.age));
			else {
				arr[t.x][t.y]-= t.age;
				live.add(new tree(t.x,t.y,t.age+1));
			}
		}
	}

	static void summer() {
		while (!dead.isEmpty()) {
			tree t = dead.poll();
			arr[t.x][t.y] += t.age / 2;
		}
	}

	static void fall() {
		while (!live.isEmpty()) {
			tree t = live.poll();
			for (int i = 0; i < 8; i++) {
				int x = t.x + dr[i];
				int y = t.y + dc[i];
				if (range(x, y) && t.age % 5 == 0) {
					list.add(new tree(x, y, 1));
				}
			}
			list.add(t);
		}
	}

	static void winter() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] += A[i][j];
			}
		}
	}
}
