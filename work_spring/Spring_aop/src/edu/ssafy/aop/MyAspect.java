package edu.ssafy.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//공통 관심사항
@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public void edu.ssafy.aop.*.doSomething())")
	public void mypt() {}
	
	//포인트컷 없으면 함수 하나 만들어주기 -> 함수 이름이 value
	@Before("mypt()")
	public void doBefore() {
		System.out.println("문을 열고 집에 들어간다.");
	}
	@AfterReturning("mypt()")
	public void doAfterReturning() {
		System.out.println("불을 끄고 잔다.");
	}
	@AfterThrowing(value="mypt()", throwing="th")
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage()+" : 119에 신고한다.");
	}
	@After("mypt()")
	public void doAfter() {
		System.out.println("문을 열고 집을 나온다.");
	}
	
}
