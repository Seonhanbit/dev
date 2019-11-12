
import java.io.*;
import java.util.*;

public class Baek_1764 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String[] ear = new String[N];
		String[] eye = new String[M];
		HashSet<String> list = new HashSet<>();
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ear[i] = br.readLine();
			list.add(ear[i]);
		}
		for (int i = 0; i < M; i++) {
			eye[i] = br.readLine();
			if (!list.add(eye[i]))
				res.add(eye[i]);
		}
		Collections.sort(res);
		bw.append(res.size()+"\n");
		for(int i=0; i<res.size(); i++)
			bw.append(res.get(i)+"\n");
		bw.flush();
		bw.close();
	}
}
