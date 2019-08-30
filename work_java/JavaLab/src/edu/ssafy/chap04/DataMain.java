package edu.ssafy.chap04;

public class DataMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date(2019, 8, 22);
		System.out.println(d.into());
		
		d.setYear(20129);
		d.getYear();
		
		d.setMonth(13);
		System.out.println(d.into());
	}

}
