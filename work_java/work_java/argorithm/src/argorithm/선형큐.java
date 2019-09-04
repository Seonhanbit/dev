package argorithm;

import java.util.Scanner;

public class 선형큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queue = new int[10];
		int front = -1;
		int rear = -1;

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. enQueue \n2. deQueue \n3.isEmpty \n0. End");
			int sel = sc.nextInt();
			if (sel == 1) {
				int num = sc.nextInt();
				// num을 큐에 삽입
				// rear를 하나 늘리고 rear자리에 데이터 삽입
				rear++;
				queue[rear] = num;
			} else if (sel == 2) {
				// 큐에서 하나 꺼내서 출력
				// front 하나 늘리고 front자리의 데이터를 인출
				front++;
				System.out.println(queue[front]);
			} else if (sel == 3) {
				// 큐의 공백 여부를 출력
				// front와 rear가 같다면 공백
				if (front == rear)
					System.out.println("공백이야");
			} else if (sel == 0) {
				break;
			}
		}
	}

}
