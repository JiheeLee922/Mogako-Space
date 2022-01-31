package com.mogako.mogakospace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MogakoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MogakoApplication.class, args);
	}

}
