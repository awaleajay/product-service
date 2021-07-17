package com.edusol.ProductDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDbApplication.class, args);
	}

}
