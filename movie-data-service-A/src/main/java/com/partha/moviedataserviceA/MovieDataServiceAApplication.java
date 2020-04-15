package com.partha.moviedataserviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieDataServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDataServiceAApplication.class, args);
	}

}
