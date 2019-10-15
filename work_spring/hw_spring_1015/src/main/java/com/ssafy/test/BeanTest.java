package com.ssafy.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

public class BeanTest {

	public static void main(String[] args) {
		BeanFactory fac = new AnnotationConfigApplicationContext(Config.class);
		ProductService pros = (ProductService)fac.getBean("service");
		int number = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=============한빛이의 상품 프로그램===========");
			System.out.println("1.추가  2.수정  3.삭제  4.조회  5.아이디조회   0.종료");
			System.out.println("========================================");
			number = sc.nextInt();
			if(number==0) break;
			switch(number) {
			case 1:
				System.out.println("추가할 id를 입력하세요.");
				String id = sc.next();
				System.out.println("추가할 name를 입력하세요.");
				String name = sc.next();
				System.out.println("추가할 price를 입력하세요.");
				int price = sc.nextInt();
				System.out.println("추가할 description를 입력하세요.");
				String description = sc.next();
				int a = pros.insert(new Product(id,name,price,description));
				if(a==0)
					System.out.println("추가 성공");
				else
					System.out.println("추가 실패");
				break;
			case 2:
				System.out.println("수정할 id를 입력하세요.");
				String id2 = sc.next();
				System.out.println("update할 name을 입력하세요.");
				String name2 = sc.next();
				System.out.println("update할 price을 입력하세요.");
				int price2 = sc.nextInt();
				System.out.println("update할 description을 입력하세요.");
				String description2 = sc.next();
				int b = pros.update(new Product(id2, name2, price2, description2));
				if(b==0)
					System.out.println("업데이트 성공");
				else
					System.out.println("업데이트 실패");
				break;
			case 3:
				System.out.println("삭제할 id를 입력하세요.");
				String id3 = sc.next();
				int res = pros.delete(id3);
				if(res==0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			case 4:
				System.out.println("현재 상품리스트를 모두 조회합니다.");
				List<Product> list = pros.selectAll();
				for(int i=0; i<list.size(); i++) {
					System.out.println(list.get(i));
				}
				break;
			case 5:
				System.out.println("조회할 아이디를 입력하세요.");
				String id5 = sc.next();
				Product product = pros.select(id5);
				System.out.println(product.toString());
				break;
			case 0:
				System.out.println("현재 프로그램을 종료합니다.");
				break;
			}
		}

	}

}
