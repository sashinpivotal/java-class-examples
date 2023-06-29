package org.supamassirichotiyakul.catermate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.supamassirichotiyakul.catermate.security.SecurityConfiguration;

@SpringBootApplication		// Use this one for real application with Spring security
public class CaterMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaterMateApplication.class, args);
	}

	// Both CommandLineRunner beans will get created and both println statements will be executed after the app started.
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> System.out.println("Cater Mate application got started!!");
	}

	@Bean
	public CommandLineRunner commandLineRunner2() {
		return args -> System.out.println("Cater Mate application got started again!!");
	}
}
