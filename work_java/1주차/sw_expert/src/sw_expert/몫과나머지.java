package sw_expert;

import java.util.Scanner;

public class 몫과나머지 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//첫줄에는 테스트 케이스의 갯수 T 입력
		int T = sc.nextInt();
		
		//각 테스트 케이스는 첫 줄에 두개의 정수가 입력됨
		for(int tc = 1; tc<=T; tc++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int q = a/b;//몫
			int r = a%b;//나머지
			
			System.out.println("#" + tc + " "+ q + " "+r);
		}
	}

}
