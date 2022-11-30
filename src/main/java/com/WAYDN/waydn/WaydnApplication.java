package com.WAYDN.waydn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WaydnApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaydnApplication.class, args);
	}

}
