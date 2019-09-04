package ws_java_0730_03_선한빛;

public class QuantityException extends Exception {


	String errmsg;

	public QuantityException() {

	}

	public QuantityException(String errmsg) {
		this.errmsg=errmsg;
	}
	
	public void showError() {
		System.out.println(errmsg);
	}


}
