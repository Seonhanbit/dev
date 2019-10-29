import java.io.*;
import java.util.*;

//계단오르기
public class Baek_2579 {
	static int N;
	static ArrayList<point> list;

	static class point {
		int cnt;
		int dic;

		point(int cnt, int dic) {
			this.cnt = cnt;
			this.dic = dic;
		}

		@Override
		public String toString() {
			return "point [cnt=" + cnt + ", dic=" + dic + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine()); // 계단의 개수
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			list.add(new point(a, 0));
		}
		int sum = list.get(N - 1).cnt;
		list.get(N - 1).dic = 1;
		int su = N - 1;
		for (int i = su; i >= 2; i--) {
			if (i == 3) {
				if (list.get(i).dic == 2) {
					sum += list.get(1).cnt;
					break;
				} else {
					int n1 = list.get(2).cnt + list.get(0).cnt;
					int n2 = list.get(1).cnt;
					int n3 = list.get(0).cnt + list.get(1).cnt;
					int nn1 = Math.max(n1, n2);
					int nn3 = Math.max(n3, nn1);
					sum += nn3;
					break;
				}
			} else {
				if (list.get(i).dic == 1) {
					if (list.get(i - 1).cnt > list.get(i - 2).cnt) {
						sum += list.get(i - 1).cnt;
						list.get(i - 1).dic = 2;
						su = i - 1;
					} else {
						sum += list.get(i - 2).cnt;
						list.get(i - 2).dic = 1;
						su = i - 2;
					}
				} else if (list.get(i).dic == 2) {
					sum += list.get(i - 2).cnt;
					su = i - 2;
					list.get(i - 2).dic = 1;
				}
			}
		}
		bw.append(sum + "\n");
		bw.flush();
		bw.close();
	}
}
