package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.example.demo")
@EnableHystrix
public class ConvertedAmountActApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertedAmountActApplication.class, args);
	}

}
