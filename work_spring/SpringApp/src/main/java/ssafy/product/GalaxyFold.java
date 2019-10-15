package ssafy.product;

public class GalaxyFold implements Phone {
	private Camera cam;
	private int price;
	public GalaxyFold() {}
	public GalaxyFold(Camera cam,int price) {
		this.cam = cam;
		this.price = price;
	}
	public void powerOn() {
		System.out.println("GalaxyFold power on!!!");
	}

	public void powerOff() {
		System.out.println("GalaxyFold Phone power off");
	}

	public void takePicture() {
		this.cam.takePicture();		
	}

	public int howmuch() {
		// TODO Auto-generated method stub
		return price;
	}

}
