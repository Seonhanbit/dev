package com.ssafy.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.ssafy.model.service","com.ssafy.model.repository", "com.ssafy.model.dto"})
public class Config {

}
