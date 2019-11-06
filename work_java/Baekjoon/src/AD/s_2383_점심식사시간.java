package AD;

import java.io.*;
import java.util.*;

public class s_2383_점심식사시간 {
	static int N, res;
	static int[][] arr;
	static ArrayList<Person> person;
	static ArrayList<Stair> stair;

	//거리 구하는 함수
	static int ck(int x, int x1, int y, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}

	static class Person implements Comparable<Person> {
		// 행,열,선택(0,1), 배열(1계단거리, 2계단거리)
		int x, y;

		Person(int x, int y) {
			this.x = x;
			this.y = y;
			dist = new int[2];
		}

		int[] dist;
		int sel;

		@Override
		public int compareTo(Person o) {
			return this.dist[sel] - o.dist[o.sel];
		}
		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", dist=" + dist + ", sel=" + sel + "]";
		}
		
	}

	static class Stair {
		int x, y, cnt;

		Stair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			person = new ArrayList<>();
			stair = new ArrayList<>();
			res = Integer.MAX_VALUE;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1)
						person.add(new Person(i, j));
					if (arr[i][j] != 1 && arr[i][j] != 0)
						stair.add(new Stair(i, j, arr[i][j]));
				}
			}

			//모든 계단으로 가는 거리를 구하기 
			//person객체의 dist 배열에 넣어줌
			for (int i = 0; i < person.size(); i++) {
				for (int j = 0; j < stair.size(); j++) {
					person.get(i).dist[j] = ck(person.get(i).x, stair.get(j).x, person.get(i).y, stair.get(j).y) + 1;
				}
			}
			powerset(0);

			bw.append("#" + tc + " " + res + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void powerset(int idx) {
		if (idx == person.size()) {
			int n = func();
			//제일 작은 놈 구해주기
			if (n < res)
				res = n;
			return;
		}
		// 0번쨰 계단과 1번째 계단을 나누는 부분집합 코드
		person.get(idx).sel = 0;
		powerset(idx + 1);
		person.get(idx).sel = 1;
		powerset(idx + 1);
	}

	static int func() {
		//0번 계단과 1번 계단이 가는 거리(아마 시간이 200초안에 끝날거야)
		int[][] timetable = new int[2][200];
		// 거리가 짧은 놈부터 timetable에 넣어주기
		PriorityQueue<Person> queue = new PriorityQueue<>();
		int sum = 0;
		for (int i = 0; i < person.size(); i++) {
			queue.add(person.get(i));
		}
		while (!queue.isEmpty()) {
			Person tmp = queue.poll();
			// 현재까지의 거리부터 계단갈때까지 timetable에 넣어주자
			// 만약 이미 3명이 찼으면 to++해줘서 1초씩 미뤄지는 거야(뒤에도 찼으면 또 1초씩 늘어나겠지?)
			int from = tmp.dist[tmp.sel];
			int to = tmp.dist[tmp.sel] + stair.get(tmp.sel).cnt;
			for (int i = from; i < to; i++) {
				if (timetable[tmp.sel][i] == 3) {
					to++;
					continue;
				}
				timetable[tmp.sel][i]++;
			}
			//제일 늦게 끝나는 놈 리턴하기
			if (sum < to)
				sum = to;
		}
		return sum;
	}
}
