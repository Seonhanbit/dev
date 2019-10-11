package D4;

import java.io.*;
import java.util.*;

public class s_7701_염라대왕의이름정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();
			//ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			ArrayList<String> list = new ArrayList<>(set);
			list.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() > o2.length())
						return 1;
					else if (o1.length() == o2.length())
						return o1.compareTo(o2);
					return -1;
				}
			});

			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+"\n");
			for (int i = 0; i < list.size(); i++)
				sb.append(list.get(i)+"\n");
			bw.write(sb.toString());
			bw.flush();
		}
		bw.close();
	}
}
