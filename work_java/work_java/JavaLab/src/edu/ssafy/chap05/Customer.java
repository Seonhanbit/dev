package edu.ssafy.chap05;

public class Customer {
	public static String service;
	protected String num;
	String name;
	int age = 10;
	public Customer(String num, String name, int age) {
		this.num = num;
		this.name = name;
		this.age = age;
	}
	public Customer() {
		System.out.println("Customer Constructor");
	}
	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
	public int toString(int a) {
		return 3;
	}
}
