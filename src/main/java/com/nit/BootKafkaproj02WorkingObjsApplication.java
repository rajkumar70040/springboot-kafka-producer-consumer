package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootKafkaproj02WorkingObjsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootKafkaproj02WorkingObjsApplication.class, args);
	}

}
