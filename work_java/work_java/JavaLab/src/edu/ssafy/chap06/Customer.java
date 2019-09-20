package edu.ssafy.chap06;

public class Customer {
	String name;
	int age;

	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
			Customer target = (Customer) obj;
			if (this.name.equals(target.name) && this.age == target.age) {
				return true;
			}
		}
		return false;
	}
}
