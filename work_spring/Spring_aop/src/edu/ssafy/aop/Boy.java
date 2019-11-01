package edu.ssafy.aop;

import org.springframework.stereotype.Component;

@Component
public class Boy implements IPerson{

	@Override
	public void doSomething() throws RuntimeException {
		System.out.println("남자인척 한다.");
		
	}

}
