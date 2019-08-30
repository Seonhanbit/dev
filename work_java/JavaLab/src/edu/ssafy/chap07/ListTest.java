package edu.ssafy.chap07;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> list= new ArrayList();
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(90);
		list.add(8);
		list.add(90);
		
		
		System.out.println(list.toString());

		for(Integer o : list) {
			System.out.println(o);
		}
		System.out.println("============");
		System.out.println(list.get(1));
		
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
