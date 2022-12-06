package br.com.erikbanking.erik.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class ErikBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErikBankingApplication.class, args);
	}

	@GetMapping("/teste")
		public String index (){


		return "Ola Mundo ";
		}

}
