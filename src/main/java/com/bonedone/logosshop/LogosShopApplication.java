package com.bonedone.logosshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class LogosShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogosShopApplication.class, args);
	}

}
