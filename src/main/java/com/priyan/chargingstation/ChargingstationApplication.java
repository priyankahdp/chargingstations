package com.priyan.chargingstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChargingstationApplication {

	public static void main(String[] args) {
    	//System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(ChargingstationApplication.class, args);
	}

}
