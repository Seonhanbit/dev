package ssafy.member.domain;

public class MemberDTO {
	private String name;
	private int age;
	
	public MemberDTO() {}

	public MemberDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", age=" + age + "]";
	}

}
