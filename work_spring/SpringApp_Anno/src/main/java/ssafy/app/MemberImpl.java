package ssafy.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mem")
public class MemberImpl implements IMember{
	private String name = "홍길동";
	private int age = 21;
	private String addr = "광산구";
	//바로 객체 타입을 찾아서 넣어주기(원래 참조해야해)
	@Autowired()
	private BigMouse big;
	public MemberImpl(String name, int age, String addr, BigMouse big) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.big = big;
	}
	
	public BigMouse getBig() {
		return big;
	}

	public void setBig(BigMouse big) {
		this.big = big;
	}

	public void init() {
		System.out.println("init Member");
	}
	public void destroy() {
		System.out.println("destroy Member");
	}
	public MemberImpl() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + ", big=" + big + "]";
	}
	
	
}
