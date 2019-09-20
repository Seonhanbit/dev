package edu.ssafy.chap07;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car[] cars = new Car[5];
		cars[0] = new Car("111", 5000);
		cars[1] = new Car("555", 6900);
		cars[2] = new Car("333", 3900);
		cars[3] = new Car("888", 8900);
		cars[4] = new Car("222", 2900);

		Arrays.sort(cars);
		Comparator<Car> com = new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return o1.price - o2.price;
			}
		};

		
		Arrays.sort(cars, com);
		for (Car car : cars) {
			System.out.println(car.toString());
		}

		System.out.println("=-=========");

		ArrayList<Car> list = new ArrayList();
		list.add(new Car("111", 5000));
		list.add(new Car("555", 6900));
		list.add(new Car("333", 3900));
		list.add(new Car("888", 8900));
		list.add(new Car("222", 2900));
		

		Collections.sort(list, com);
		for (Car car : list) {
			System.out.println(car.toString());
		}

	}

}
