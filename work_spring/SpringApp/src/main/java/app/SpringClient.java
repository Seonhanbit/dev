package app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		// 일반적인 자바 방법
		// Member m = new Member();
		// System.out.println(m.toString());

		// Spring Container 이용하기
		// 경로 지정(main/resources) applicationContext.xml > spring bean configuration file 만들기
		// namespace에서 context, aop 클릭
		BeanFactory cxt = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		System.out.println("BeanFactory 생성");
		//객체를 부르는 2가지 방법
//		IMember mem1 = cxt.getBean(MemberImpl.class);
		IMember mem2 = (IMember) cxt.getBean("mem");
//		System.out.println("Member 가져오기");
		System.out.println(mem2.toString());
		//singleton일때 mem2지만 바로 바뀌어버림
//		mem1.setName("둘리");  
//		System.out.println(mem2.toString());
		
	}

}
