package edu.ssafy.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		IPerson boy = context.getBean("boy", IPerson.class);
		IPerson girl = context.getBean("girl", IPerson.class);
		try {
			boy.doSomething();
			girl.doSomething();
		} catch (RuntimeException e) {

		}

	}

}
