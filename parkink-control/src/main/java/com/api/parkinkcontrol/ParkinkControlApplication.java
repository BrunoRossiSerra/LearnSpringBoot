package com.api.parkinkcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@ComponentScan
public class
ParkinkControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkinkControlApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Ola Mundo";
	}
}
