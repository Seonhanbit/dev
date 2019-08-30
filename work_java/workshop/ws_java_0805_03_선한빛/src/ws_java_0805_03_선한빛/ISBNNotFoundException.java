package ws_java_0805_03_선한빛;

public class ISBNNotFoundException extends Exception {
	String errmsg;

	public ISBNNotFoundException() {

	}

	public ISBNNotFoundException(String errmsg) {
		this.errmsg=errmsg;
	}
	
	public void showError() {
		System.out.println(errmsg);
	}
}
