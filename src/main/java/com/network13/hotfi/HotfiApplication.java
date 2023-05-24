package com.network13.hotfi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HotfiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotfiApplication.class, args);
	}

}
