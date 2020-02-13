package com.eke.demoWebrtc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoWebrtcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebrtcApplication.class, args);
	}

}
