package edu.ssafy.model;

public class Product {
	private String pno;
	private String pname;
	private int pprice;

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public Product(String pno, String pname, int pprice) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
	}

	Product() {

	}

}
