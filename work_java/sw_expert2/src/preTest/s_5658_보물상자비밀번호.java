package preTest;

import java.io.*;
import java.util.*;

public class s_5658_보물상자비밀번호 {
	static int T, N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			Queue<Character> queue = new LinkedList<>();
			String str = br.readLine();
			for (int i = 0; i < N; i++)
				queue.add(str.charAt(i));
			// 뽑은 16진수
			ArrayList<String> list = new ArrayList<>();
			//Set<Integer> set = new TreeSet();
			// 16진수를 10진수로 변환한 값
			ArrayList<Integer> res = new ArrayList<>();
			int cnt = 0;
			int su = N / 4; //하나의 길이
			//str.substring(여기부터,여기까지)
			while (true) {
				if (cnt == su)
					break;
				String sum = "";
				for (int i = 1; i < N + 1; i++) {
					char a = queue.poll();
					sum += a;
					if (i % su == 0) {
						if (!list.contains(sum))
							list.add(sum);
						sum = "";
					}
					queue.add(a);
				}
				queue.add(queue.poll());
				cnt++;
			}
			//System.out.println(list.toString());
			for (int i = 0; i < list.size(); i++) {
				res.add(Integer.parseInt(list.get(i), 16));
			}
			Comparator<Integer> com = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			};
			Collections.sort(res, com);
			bw.append("#").append(String.valueOf(tc)).append(" ").append(res.get(K - 1) + "\n");
			bw.flush();
		}
		bw.close();
	}
}
