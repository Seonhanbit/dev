package edu.ssafy.chap04;

public class Date {
	private int year;
	private int month;
	private int day;

	public void setYear(int year) {
		if (year >= 2100 || year < 1900) {
			System.out.println("입력하신 년도는 범위를 벗어납니다.");
		} else {
			this.year = year;
		}
	}
	public int getYear() {
		return year;
	}
	
	public void setMonth(int month) {
		if (0 <month && month <= 12) {			
			this.month = month;
		}else {
			System.out.println("입력하신  월은 범위를 벗어납니다.");
		}
	}
	public int getMonth() {
		return month;
	}
	
	public void setDay(int day) {		
			this.day = day;
	}
	public int getDay() {
		return day;
	}

	public Date() {
	}

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String into() {
		return this.year + " " + month + " " + day;
	}

}
