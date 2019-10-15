package ssafy.product;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsePhone {

	public static void main(String[] args) {
		BeanFactory fac = new ClassPathXmlApplicationContext("/ssafy/phone/config/phonebean.xml");
		Phone phone = (Phone)fac.getBean("apple");
		phone.powerOn();
		phone.takePicture();
		phone.powerOff();
		System.out.println(phone.howmuch());
	}

}
