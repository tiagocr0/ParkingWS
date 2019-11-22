package br.edu.ifsc.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ParkingWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingWsApplication.class, args);
	}

}
