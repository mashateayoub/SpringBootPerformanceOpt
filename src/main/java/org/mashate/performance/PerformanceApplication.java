package org.mashate.performance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceApplication.class, args);
	}

}
