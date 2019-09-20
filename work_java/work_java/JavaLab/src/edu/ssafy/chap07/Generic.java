package edu.ssafy.chap07;

public class Generic <I>{
	I i;
	
	public void setI(I i) {
		this.i = i;
	}
	public I getI() {
		return i;
	}
}

class Sub extends Generic<String>{
	@Override
	public void setI(String i) {
		// TODO Auto-generated method stub
		super.setI(i);
	}
	
	@Override
	public String getI() {
		// TODO Auto-generated method stub
		return super.getI();
	}

}
