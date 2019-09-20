package sw_expert;

import java.util.Scanner;
public class  s_1204_최빈수{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i= 0; i<T; i++)
        {
            int [] arr = new int [101];
            
            sc.nextInt();
            for(int j =0; j<1000; j++){
                int tmp = sc.nextInt();
                arr[tmp] +=1;
                }
            //배열 제일 큰 것 찾기
            int max=0;
            int resul=0;
            for(int a=0; a<arr.length; a++){
            	//최빈수가 여러개일때는 가장 큰 점수 출력
            	//0부터 100까지 실행하니까 뒤로 갈 수록 큰 것 갱신 필요
                if(max <= arr[a]) {
                	
                	resul=a;
                    max = arr[a];   
                }
            }            
            System.out.println("#"+(i+1)+" "+resul);
        }
    }
}
