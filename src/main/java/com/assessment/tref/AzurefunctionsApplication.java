package com.assessment.tref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class AzurefunctionsApplication {

	@Bean
	public Function<String, String> uppercase(){
		return input -> String.format("input was %s; all uppercased is: %s", input, input.toUpperCase());
	}

	public static void main(String[] args) {
		SpringApplication.run(AzurefunctionsApplication.class, args);
	}

}
