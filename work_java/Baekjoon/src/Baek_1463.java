
import java.io.*;
import java.util.*;

//1로 만들기
public class Baek_1463 {
	static int N, min;
	static Map<Integer, Integer> map = new HashMap();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		div(N, 0);
		bw.append(min + "\n");
		bw.flush();
		bw.close();
	}

	static void div(int n, int cnt) {
		if (n == 1) {
			min = Math.min(min, cnt);
			return;
		}
		if (map.containsKey(n)) {
			if (map.get(n) <= cnt) {
				map.put(n, cnt);
				return;
			}
		} else
			map.put(n, cnt);

		if (n % 3 == 0)
			div(n / 3, cnt + 1);
		if (n % 2 == 0)
			div(n / 2, cnt + 1);

		div(n - 1, cnt + 1);
	}
}
