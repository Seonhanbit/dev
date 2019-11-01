package edu.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class Girl implements IPerson{

	@Override
	public void doSomething() throws RuntimeException {
		System.out.println("여자인척 한다.");
		if(new Random().nextBoolean())
			throw new RuntimeException("화재발생");
	}

}
