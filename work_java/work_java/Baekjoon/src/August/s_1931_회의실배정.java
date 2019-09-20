package August;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class s_1931_회의실배정 {
	static class Time implements Comparable<Time> {
		public int start;
		public int end;
		
		Time(int s, int e){
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Time o) {
			if(end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Time[] tm = new Time[n];
		for (int i = 0; i < n; i++) {
			tm[i]= new Time(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(tm);
		int s = tm[0].start;
		int e = tm[0].end;
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if(e <= tm[i].start) {
				s = tm[i].start;
				e = tm[i].end;
//				System.out.println(tm[i].start +","+tm[i].end);
				cnt++;
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(tm[i].toString());
		}
		System.out.println(cnt);
	}

}
