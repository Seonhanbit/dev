package ssafy.product;

public class ApplePhone implements Phone {
	private int price;
	private Camera cam;
	public ApplePhone() {}
	public ApplePhone(Camera cam,int price) {
		this.cam = cam;
		this.price = price;
	}

	public Camera getCam() {
		return cam;
	}
	public void setCam(Camera cam) {
		this.cam = cam;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public void powerOn() {
		System.out.println("Apple Phone power on!!!!");
	}


	public void powerOff() {
		System.out.println("Apple Phone power off");
	}


	public void takePicture() {
		this.cam.takePicture();		
	}

	public int howmuch() {
		// TODO Auto-generated method stub
		return price;
	}


}
