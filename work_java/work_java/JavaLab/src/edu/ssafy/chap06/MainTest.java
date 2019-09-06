package edu.ssafy.chap06;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.name = "kim";
		c.age = 10;
		
		Customer c2 = new Customer();	
		c2.name = "kim";
		c2.age = 10;
		
		//주소 값 비교 c==c2 거짓 
		//데이터가 같으면 같은 객체라고 정하고 싶을때 c.equals(c2) equals 오버 라이딩 하여 사용 
		//if(c.age == c2.age && c.name.equals(c2.name)) 
		//클래스 만든 사람과 쓰는 사람은 다르니까 미리 equals로 함수 만들어 주기
		if(c.equals(c2)) {
			System.out.println("같아요");
		}else {
			System.out.println("달라요");
		}
	}

}
