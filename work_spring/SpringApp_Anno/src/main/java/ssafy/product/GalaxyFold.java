package ssafy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="galaxy")
public class GalaxyFold implements Phone {
	@Autowired
	@Qualifier("samsungcam")
	private Camera cam;
	private int price;
	public GalaxyFold() {}
	public GalaxyFold(Camera cam,int price) {
		this.cam = cam;
		this.price = price;
	}
	@Override
	public void powerOn() {
		System.out.println("GalaxyFold power on!!!");
	}

	@Override
	public void powerOff() {
		System.out.println("GalaxyFold Phone power off");
	}

	@Override
	public void takePicture() {
		this.cam.takePicture();		
	}
	@Override
	public int howmuch() {
		// TODO Auto-generated method stub
		return price;
	}


}
