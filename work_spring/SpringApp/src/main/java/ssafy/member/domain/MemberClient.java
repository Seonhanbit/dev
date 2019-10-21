package ssafy.member.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssafy.member.biz.MemberService;

public class MemberClient {
	//서블릿 역할
	public static void main(String[] args) {
		BeanFactory fac = new AnnotationConfigApplicationContext(MemberConfig.class);
		//BeanFactory fac = new ClassPathXmlApplicationContext("/membercontext.xml");
		MemberService ser = (MemberService)fac.getBean("memberser");
		ser.memberInsert("홍길동", "21");
		ArrayList<MemberDTO> list = ser.memberSelectList();
		ser.memberUpdate("hh", "21");
		ser.memberDelete("");
	}

}
