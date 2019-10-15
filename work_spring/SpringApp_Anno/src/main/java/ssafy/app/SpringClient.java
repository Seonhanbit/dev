package ssafy.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		// BeanFactory fac = new ClassPathXmlApplicationContext("/ssafy/spring/config/config.xml");
		
		BeanFactory fac = new AnnotationConfigApplicationContext(Config.class);
		
		
		IMember mem = (IMember) fac.getBean("mem");
		mem.setBig(new BigMouse("최민혜"));
		System.out.println(mem.toString());
		
		BigMouse big = (BigMouse) fac.getBean("bigmouse");
		System.out.println(big.toString());
	}

}
