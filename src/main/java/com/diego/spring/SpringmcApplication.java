package com.diego.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.spring.services.MinioService;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner{
	
	@Autowired
	private MinioService minioService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		minioService.uploadFile("C:\\imagensTrab\\sinon.jpg");
	}
}
