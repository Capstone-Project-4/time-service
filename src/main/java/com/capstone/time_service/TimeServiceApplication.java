package com.capstone.time_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeServiceApplication.class, args);
	}

}
