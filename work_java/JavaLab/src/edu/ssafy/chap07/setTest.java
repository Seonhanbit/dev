package edu.ssafy.chap07;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class setTest {

	public static void main(String[] args) {
		
		TreeSet<String> set = new TreeSet();
//		HashSet set = new HashSet();
//		set set = new HashSet();
//		Collection set = new HashSet();
		
		set.add("Seoul");
		set.add("Gwangju");
		set.add("Gumi");
		set.add("Daejeon");
		set.add("Gwangju");
		
		System.out.println(set.first());
		System.out.println(set.last());
		
		//treeset이 tostring을 오버라이딩 한 결과
		System.out.println(set.toString());
		
		for(Object o :set) {
			System.out.println(o);
		}
		Set<Car> set2 = new TreeSet();
		set2.add(new Car());
		set2.add(new Car());
		set2.add(new Car());
		
//		for(Car car : set2) {
//			System.out.println(car.toString());
//		}
//		
		
	}

}
