package com.perscholas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext
				= SpringApplication.run(SpringDataJpaDemoApplication.class, args);

	}

}
