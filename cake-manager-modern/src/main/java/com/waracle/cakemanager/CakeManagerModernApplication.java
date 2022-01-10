package com.waracle.cakemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.waracle.cakemanager.config.CakeManagerConfig;

@SpringBootApplication
@Import(value = {CakeManagerConfig.class})
public class CakeManagerModernApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeManagerModernApplication.class, args);
	}

}
