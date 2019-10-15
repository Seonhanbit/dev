package ssafy.product;

import org.springframework.stereotype.Component;

@Component(value="canoncam")
public class CanonCamera implements Camera {

	@Override
	public void takePicture() {
		System.out.println("Canon Camera 찰칵>.<");
	}

}
