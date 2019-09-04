package algorithm;

public class 비트마스크부분집합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사과 오렌지 배를 모든 경우의 수로 뽑아봅시다.
		// 원소가 3개니까 8가지 방법이 있음
		String[] fruits = { "사과 ", "오렌지 ", "배 " };
		for (int i = 0; i < (1 << fruits.length); i++) {
			for (int j = 0; j < fruits.length; j++) {

				if (((1 <<j) & i) != 0)
					System.out.print(fruits[j]);
			}

//			//0~7로 변하는 i를 검사해서 
//			//맨 오른쪽 비트가 1이면 사과 포함. 맨 오른쪽 한 비트가 1이라는 숫자와 &연산해서 0이 ㄴㄴ아니면 ㅇㅇ
//			if(((1<<0)&i) !=0)
//				System.out.print(fruits[0]);
//			
//			//맨 오른쪽 두번째 비트가 1이면 오렌지 포함 
//			//맨 오른쪽 두번째 비트만 1인 2와 &연산
//			if((2&i) !=0)
//				System.out.print(fruits[1]);
//			//맨 오른쪽 두번째 비트라는건 1을 왼쪽으로 한칸 밀어낸 것 1<<1
//			//맨 오른쪽 세번째 비트가 1이면 배 포함
//			//맨 오른쪽  세번째 비트가 1인지 검사하려면 맨 오른쪽 세번째 비트만 1인 4와 &연산 
//			if((4&i) !=0)
//				System.out.print(fruits[2]);
//			//저놈은 1<<2

			System.out.println();
		}
	}

}
