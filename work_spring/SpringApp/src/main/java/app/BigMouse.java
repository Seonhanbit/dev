package app;

public class BigMouse {
	private String name;
	public BigMouse() {	}
	public BigMouse(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BigMouse [name=" + name + "]";
	}
}
