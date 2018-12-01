package com.itc.apti.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class ITCAptimusSupportApp is the main class for Spring Boot application.
 * 
 * @author Debadatta Mishra
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.itc.apti.*")
public class ITCAptimusSupportApp {

	/**
	 * The main method for Spring Boot Application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ITCAptimusSupportApp.class, args);
	}
}
