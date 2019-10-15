package ssafy.product;

import org.springframework.stereotype.Component;

@Component(value="samsungcam")
public class SamsungCamera implements Camera{

	@Override
	public void takePicture() {
		System.out.println("SamsungCamera 찰칵>_<");
	}

}
