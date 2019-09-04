package sw_expert2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class s_1233_사칙유효성 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());

			Queue<Integer> q1 = new LinkedList<>(); // subtree가 두개인가? 연산자면 두개여야됨
			Queue<Integer> q2 = new LinkedList<>(); // 자식 노드가 피연산자 인가?

			String[] str = new String[N];

			int half = N / 2;
			int cnt = 0;
			int cnt2 = 0;

			for (int i = 0; i < N; i++) {
				str[i] = br.readLine();
			}

			for (int i = 0; i < half; i++) {
				StringTokenizer st = new StringTokenizer(str[i]);
//				while(st.hasMoreTokens()) 안에 nextToken해주고 없어질때까지 돈다
				st.nextToken();
				char c = st.nextToken().charAt(0);
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					cnt++;
				}
			}


			for (int i = half; i < N; i++) {
				StringTokenizer st = new StringTokenizer(str[i]);
				st.nextToken();
				String s = st.nextToken();
				if (s.charAt(0) - '0' >=0) {
//					int val = Integer.parseInt(s);
					cnt2++;
				}
			}
			// 완전 이진 트리를 보장해줬기때문에
			// 연산자 나오기 전 부모까지 피연산자 그 부모들은 모두 피연산자
			// 171이면 절반까지는 연산자가 나와야됨
			// 168이면 84까지는 연산자가 나와야됨

			System.out.print("#" + tc + " ");
			if(cnt == half && cnt2 ==half+1) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
			
			
			
			
			/*
			int N = Integer.parseInt(sc.nextLine());
			//N이 짝수면 글렀다
			if(N%2==0) {
			for(int i= 1; i<=N; i++){
				sc.nextLine();
				System.out.println("#"+tc+" "+ 0);
			}else {
				//N이 179라면 몇번까지 연산자? 89까지 연산자가 나와야해. 90이후로는 끝까지는 피연산자
				 for(int i =1; i<=N/2; i++) {
					 sc.nextLine().split(" "); // 1 - 2 3 공백을 기준으로 문자열을 분리시켜서 배열이 됨
					 char c = str[1].charAt(0);
					 if (c == '-' || c == '+' || c == '*' || c == '/') {
					 
					 }else{
					 	result = 0;
					 }
				 }
				 for(int i =N/2+1; i<N; i++) {
					 sc.nextLine().split(" "); // 1 - 2 3 공백을 기준으로 문자열을 분리시켜서 배열이 됨
					 char c = str[1].charAt(0);
					 if (c >='0' && c <= '9') {
					 
					 }else{
					 	result = 0;
					 }
				 }
				
			}
			*/
		}
	}
}
