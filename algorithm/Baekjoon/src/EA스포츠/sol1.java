package EA스포츠;

import java.io.*;
import java.util.*;

public class sol1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] user_times = { 2, 4, 6, 10 };
		int answer = solution(user_times, 2);
		System.out.println(answer);
	}

	public static int solution2(int[] user_times, int T) {
		int answer = 0;
		int cnt = 0;

		for (int i = 0; i < user_times.length; i++) {
			int tmp = T - (user_times[i] % T);
			if (user_times[i] % T == 0) {
				cnt++;
			}
			if (tmp > answer) {
				answer = tmp;
			}
		}
		if (cnt == user_times.length)
			answer = 0;

		return answer;
	}

	public static int solution(int[] user_times, int T) {
		int answer = 0;
		for (int i = 0; i < user_times.length; i++) {
			if (user_times[i] % T != 0) {
				answer = Math.max(answer, T - user_times[i]%T);
			}
		}
		return answer;
	}

}
