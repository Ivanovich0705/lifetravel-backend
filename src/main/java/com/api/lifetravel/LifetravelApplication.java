package com.api.lifetravel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LifetravelApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(LifetravelApplication.class, args);
	}


}
