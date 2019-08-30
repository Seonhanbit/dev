package edu.ssafy.chap05;

public class DepartmentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer[] cArr = new Customer[9];
		cArr[0] = new Customer("111", "둘리", 8);
		cArr[0].age =11;
		cArr[1] = new Customer("222", "또치", 9);
		cArr[2] = new Customer("333", "도우너", 10);
//		
//		for(int i=0; i<cArr.length; i++) {
//			System.out.println(cArr[i].toString());
//		}
		
//		VipCustomer[] vArr = new VipCustomer[3];
		cArr[3] = new VipCustomer("211", "고길동", 40, "둘리혼내기");
		cArr[4] = new VipCustomer("212", "박길동", 30, "발렛파킹");
		cArr[5] = new VipCustomer("213", "홍길동", 20, "호형호제");
		cArr[6] = new 진상();
		cArr[7] = new 진상();
		cArr[8] = new 진상();
		
		toArray(cArr);

	}
	public static void toArray(Customer[] arr) {
//		if(arr[5] instanceof 진상) {
//			진상 c = (진상)arr[5];
//		}
//		//원래 진상인 타입 변수에 (진상) 형변환 downcasting 으로 바꿔주기
//		진상 c = (진상)arr[6];
//		System.out.println(c.진상부리기());
		for(int i=0; i<arr.length; i++) {
			if(arr[i] instanceof 진상) {
				진상 c = (진상)arr[i];
				System.out.println(c.진상부리기());
			}
		}

	}
}
