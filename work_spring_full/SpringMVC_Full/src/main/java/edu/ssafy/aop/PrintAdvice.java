package edu.ssafy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintAdvice {
	
	//@Before("execution(* *..MemberService.insert(..))")
	public void printBefore(JoinPoint jp) {
		//System.out.println(jp.getSignature().getName());
		System.out.println("AOP Before print");
	}
//	@After("execution(* app.Galaxy*.volumeUp(..))")
//	public void printAfter(JoinPoint jp) {
//		//System.out.println(jp.getSignature().getName());
//		System.out.println("AOP After print");
//	}
//	@Around("execution(* app.Galaxy*.volumeDown(..))")
//	public void printAround(ProceedingJoinPoint jp) throws Throwable {
//		//System.out.println(jp.getSignature().getName());
//		System.out.println("AOP Around before print");
//		jp.proceed();
//		System.out.println("AOP Around after print");
//	
//	}
}
