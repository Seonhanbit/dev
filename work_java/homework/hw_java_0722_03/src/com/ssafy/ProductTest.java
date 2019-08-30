package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
		TV[] T = new TV[5];
		Refrigerator[] R = new Refrigerator[5];
				
		T[0] = new TV(1, "남바1", 20000, 51, 13, "SD");
		T[1] = new TV(2, "남바2", 30000, 20, 13, "DS");
		T[2] = new TV(3, "남바3", 40000, 30, 15, "SSD");
		T[3] = new TV(4, "남바4", 50000, 14, 17, "SDS");
		T[4] = new TV(5, "남바5", 60000, 15, 19, "SF");
		
		R[0] = new Refrigerator(5, "냉장1", 120000, 2, 3000);
		R[1] = new Refrigerator(4, "냉장2", 240000, 4, 7000);
		R[2] = new Refrigerator(3, "냉장3", 340000, 6, 5000);
		R[3] = new Refrigerator(2, "냉장4", 520000, 8, 4000);
		R[4] = new Refrigerator(1, "냉장5", 620000, 9, 2000);
		
		
		for(int i=0; i<T.length; i++) {
			System.out.println(T[i]);
		}
		
		System.out.println("**********************************************************");
		
		for(int i=0; i<R.length; i++) {
			System.out.println(R[i]);
		}

	}

}
