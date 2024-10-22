package com.epam.spring.Employee;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeApplication {

	@Value("${addressservice.base.url}")
	private String addressBaseUrl;
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
    public WebClient webClient(){
		return WebClient
				.builder()
				.baseUrl(addressBaseUrl)
				.build();

	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
