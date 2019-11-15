import java.io.*;
import java.util.*;

//달팽이
public class Baek_1913_달팽이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int find = sc.nextInt();
		int findX = 0, findY = 0;

		int[][] arr = new int[n][n];
		int y = -1, x = 0;
		int s = 1;
		int num = n * n;

		//0,0부터 채워보자 
		while (num != 0) {
			// 세로줄 채우기
			for (int i = 0; i < n; i++) {
				y += s; //아래 가기위해서 1씩 더해줌
				arr[y][x] = num;
				if (num == find) {
					findY = y;
					findX = x;
				}
				num--;
			}
			//한칸씩 안쪽으로 이동
			n--;

			for (int i = 0; i < n; i++) {
				x += s; //오른쪽 가기위해 1씩 더해줌
				arr[y][x] = num;
				if (num == find) {
					findY = y;
					findX = x;
				}
				num--;
			}

			//방향 바꾸기
			if (s == 1)
				s = -1;
			else if (s == -1)
				s = 1;
		}

		// 결과값 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.printf("\n");
		}
		System.out.print((findY + 1) + " " + (findX + 1) + "\n");
	}
}
