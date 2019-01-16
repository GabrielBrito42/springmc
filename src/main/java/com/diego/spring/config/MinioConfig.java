package com.diego.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;


@Configuration
public class MinioConfig {

	@Bean
	public MinioClient mMinioClient() throws InvalidEndpointException, InvalidPortException {
		MinioClient minioClient = new MinioClient("http://127.0.0.1:9000", "HO6R2O2200RRG5PRIAJ7", "fDj5E1EmQsxpFgSAYFTWRRPcxhUVwWUz5+FK7qHe");
		return minioClient;
	}
	
}
