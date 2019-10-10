package D4;

import java.util.*;

public class s_4796_의석이의우뚝선산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] mountain; // 산의 높이들을 저장할 배열
			int result = 0; // 우뚝선산의 값
			int N = sc.nextInt();
			mountain = new int[N];
			for (int i = 0; i < N; i++)
				mountain[i] = sc.nextInt();
			// 올라가는 카운트, 내려가는 카운트
			int up = 0;
			int down = 0;
			for (int i = 1; i < mountain.length; i++) {
				// 앞에 지점보다 내가 높으면 up++
				if (mountain[i - 1] < mountain[i]) {
					if (up == 0 && down > 0)
						down = 0;
					else if (up > 0 && down > 0) {
						// 올라가는 상황이면서, up과 down이 둘다 0보다 크다면 새로운 우뚝선산의 시작
						// up*down만큼 우뚝선산을 카운트
						result += up * down;
						up = 0;
						down = 0;
					}
					up++;
				}
				// 아니면 down++
				else
					down++;
			}
			if (up > 0 && down > 0)
				result += up * down;
			System.out.println("#" + tc + " " + result);
		}
	}

}

/*for (int i = 1; i < N; i++) {
    if (mountain[i - 1] < mountain[i]) {
        if (down > 0) {
            result += up * down;
            up = 0;
            down = 0;
        }
        up++;
    }
    else {
        down++;
    }
}*/
