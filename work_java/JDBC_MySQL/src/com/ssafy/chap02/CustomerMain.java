package com.ssafy.chap02;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerMain {

	public static void main(String[] args) {
		DBManager man = null;
		try {
			man = new DBManager();
//			man.insertCustomer("홍길동", 21, "광산구");
//			man.insertCustomer("박길동", 41, "광산구");
//			man.insertCustomer("고길동", 31, "광산구");
//			
//			man.updateCustomer(2, "둘리", 2, "쌍문동");
			
//			man.deleteCustomer(2);
			CustomerVO c = man.queryCustomerByNum(1);
			System.out.println(c);
			
//			ArrayList<CustomerVO> list = man.queryCustomer();
//			for(CustomerVO vo : list) {
//				System.out.println(vo);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			man.close();
		}
		

	}

}
