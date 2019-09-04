package edu.ssafy.chap05;

public class VipCustomer extends Customer {

	String service;
	int age = 20;
	public VipCustomer(String num, String name, int age, String service) {
		super(num, name, age);
		super.toString();
		this.service = service;
	}
	public VipCustomer() {
		System.out.println("VipCustomer Constructor");
	}
	@Override
	public String toString() {
		return "VipCustomer [num=" + num + ", name=" + name + ", age=" + age + ", service=" + service + "]";
	}
	
}
