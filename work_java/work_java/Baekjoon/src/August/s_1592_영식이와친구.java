package August;

import java.util.Scanner;

public class s_1592_영식이와친구 {

	public static void main(String[] args) {
		//공을 지금 든 놈의 카운트가 홀수면 오른쪽으로 보냄, 짝수면 왼쪾으로 보냄
		//배열 밖으로 나가는 경우 뱅ㄹ의 크기만큼 빼거나 더해주면 됨
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int[] arr = new int[n];
		
		int idx = 0;// 현재 공 들고 있는놈
        int total = 0;//패스횟수
        while(true) {
            arr[idx]++;
            if( arr[idx] == m)
                break;
            if (arr[idx] % 2 == 1) {
                idx = idx + l;
                if (idx >= n)
                    idx -= n;
            } else {
                idx = idx - l;
                if (idx < 0) {
                    idx += n;
                }
            }
            total++;
        }
        System.out.println(total);
		
	}

}
