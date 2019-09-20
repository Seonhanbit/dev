package edu.ssafy.chap09;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ParallelTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1길동","2길동","3길동","4길동","5길동","6길동","7길동","8길동","9길동","10길동","11길동","12길동","13길동","14길동","15길동");
		Stream<String> stream = list.stream();
		stream.forEach(ParallelTest::print);
		
		Stream<String> parall = list.parallelStream();
		parall.forEach(ParallelTest::print);
		
		
		List<Integer> listi = Arrays.asList(100, 200, 300, 400, 500, 600);
		Stream<Integer> stream2 = listi.stream();
		stream2.forEach(ParallelTest::print);
		Stream<Integer> paralleStream = listi.parallelStream();
		paralleStream.forEach(ParallelTest::print);
		
		
		stream.forEach(name -> System.out.println(name));
		paralleStream.forEach(name -> System.out.println(name));
	}
	
	public static void print(String str) {
		System.out.println(str +" : "+Thread.currentThread());
	}
	
	public static void print(Integer str) {
		System.out.println(str +" : "+Thread.currentThread());
	}


}
