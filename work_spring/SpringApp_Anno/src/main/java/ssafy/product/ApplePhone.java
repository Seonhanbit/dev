package ssafy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="apple")
public class ApplePhone implements Phone {
	private int price;
	// Camera가 여러개니까 Qualifier 설정해줌
	@Autowired
	@Qualifier("canoncam")
	private Camera cam;
	public ApplePhone() {}
	

	public ApplePhone(Camera cam,int price) {
		this.cam = cam;
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("Apple Phone power on!!!!");
	}

	@Override
	public void powerOff() {
		System.out.println("Apple Phone power off");
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
