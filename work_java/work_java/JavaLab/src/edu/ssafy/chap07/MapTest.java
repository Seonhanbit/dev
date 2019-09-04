package edu.ssafy.chap07;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> m = new HashMap();
		
		m.put(1, "seoul");
		m.put(2, "Gwangju");
		m.put(3, "Gumi");
		m.put(4, "Daejeon");
		
		System.out.println(m.get(3));
		
		for(Integer key : m.keySet()) {
			System.out.println(key+":"+m.get(key));
		}
	}

}
