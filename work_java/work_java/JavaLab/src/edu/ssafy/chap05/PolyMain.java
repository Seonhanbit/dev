package edu.ssafy.chap05;

public class PolyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		System.out.println(c.toString());
		VipCustomer vc = new VipCustomer();
		System.out.println(vc.toString());
		
		//안전한 형변환(Customer) 생략 가능
		Customer cc = new VipCustomer();
		System.out.println(cc.toString());
//		VipCustomer vv = (VipCustomer)new Customer();
		
		objectPrint(c);
		objectPrint(vc);
		objectPrint(cc);
	}
	
	public static void objectPrint(Customer v) {
		System.out.println(v.toString());
	}
	
//	public static void objectPrint(VipCustomer v) {
//		System.out.println(v.toString());
//	}

}
