package August;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s_1966_two {
	static class Document {
		int idx;
		int priority;

		Document(int _idx, int _priority) {
			this.idx = _idx;
			this.priority = _priority;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N];
			int[] parr = new int[10]; //우선순위 9를 가진 갯수가 value값
			Queue<Document> queue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				int idx = i;
				int priority = sc.nextInt();
				parr[priority]++;
				Document d = new Document(idx, priority);
				queue.add(d);
			}
			//우선순위가 높은 애부터 나와야하는데
			//우선순위배열의 9번칸이 0보다 크다면 우선순위가 9인애가 있는거니까
			//9보다 낮은 우선순위면 다시 줄세움
			//9면 출력한거로 간주하고 9번칸 값을 하나 줄임
			
			//위와 같이 큰 우선순위부터 반복을 하면서 순서가 m인 녀석이 나오면 종료
			
			//지금까지 몇개가 출력되었는지 저장할 변수
			int count = 0;
			//현재 검사하는 우선순위...
			int idx = 9;
			while(true) {
				if(parr[idx]==0) {
					idx--;
					if(idx==0)
						break;
				}else {
					Document d = queue.poll();
					//현재 검사하는 우선순위에 일치하는 문서라면
					if(d.priority == idx) {
						count++; //출력했으니 카운트 하나 세고 해당 우선순위 문서수를 하나 줄임.
						parr[idx]--;
						if(d.idx == M) {
							break;
						}
					}else {
						//우선순위 더 낮은 아이라면 뒤에가서 줄서
						queue.add(d);
					}
				}
			}
			System.out.println(count);
		}
	}
}
