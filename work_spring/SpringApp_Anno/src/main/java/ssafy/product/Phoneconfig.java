package ssafy.product;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="ssafy.product")
public class Phoneconfig {
	public String getDBConnection() {
		return "connected";
	}
}
