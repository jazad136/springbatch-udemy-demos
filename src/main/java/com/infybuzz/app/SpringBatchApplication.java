package com.infybuzz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.infybuzz.config", "com.infybuzz.service"})
public class SpringBatchApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}
}
