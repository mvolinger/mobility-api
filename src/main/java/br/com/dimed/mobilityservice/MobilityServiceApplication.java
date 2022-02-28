package br.com.dimed.mobilityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MobilityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilityServiceApplication.class, args);
	}

}
