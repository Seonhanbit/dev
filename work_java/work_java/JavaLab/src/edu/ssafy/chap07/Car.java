package edu.ssafy.chap07;

import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable{
	String num;
	int price;
	
	public Car() {
		
	}
	
	public Car(String num, int price) {
		this.num = num;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [num=" + num + ", price=" + price + "]";
	}

	//price는 현재 p값, o.price는 다음 비교할 값
	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		if(o !=null) {
			return o.price - price;
		}
		return 0;
	}
}
