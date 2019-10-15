package ssafy.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 이 행동을 하는 것!
/*<context:component-scan base-package="ssafy.app"></context:component-scan>*/

@Configuration
@ComponentScan(basePackages="ssafy.app")
public class Config {

}
