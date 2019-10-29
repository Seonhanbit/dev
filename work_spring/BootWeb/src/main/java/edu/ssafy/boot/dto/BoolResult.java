package edu.ssafy.boot.dto;

public class BoolResult {
	private String name;
	private boolean count = false;
	private String state = "true";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCount() {
		return count;
	}
	public void setCount(boolean count) {
		this.count = count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "BoolResult [name=" + name + ", count=" + count + ", state=" + state + "]";
	}
	public BoolResult(String name, boolean count, String state) {
		super();
		this.name = name;
		this.count = count;
		this.state = state;
	}
	public BoolResult() {
	}

}
