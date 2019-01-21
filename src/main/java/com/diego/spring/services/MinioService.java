package com.diego.spring.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidExpiresRangeException;
import io.minio.errors.NoResponseException;
import io.minio.errors.RegionConflictException;

@Service
public class MinioService {

	@Autowired
	private MinioClient minioClient;
	
	public URI uploadFile(MultipartFile multipartFile) throws RegionConflictException, IOException, InvalidExpiresRangeException {
		String fileName = multipartFile.getOriginalFilename();
		InputStream is = multipartFile.getInputStream();
		String contentType = multipartFile.getContentType();
		return uploadFile(is, fileName, contentType);
	}
	
	public URI uploadFile(InputStream is, String fileName, String contentType) throws RegionConflictException, InvalidExpiresRangeException  {
		try {
				minioClient.putObject("springmc", fileName, is, contentType);
				return URI.create(minioClient.presignedGetObject("springmc", fileName));
			} catch (InvalidArgumentException e) {
				e.printStackTrace();
		} catch(InvalidBucketNameException e) {
			System.out.println("Nome do bucket é invalido");
		} catch(NoSuchAlgorithmException e) {
			System.out.println("O algoritmo requisitado não foi encontrado durante o calculo");
		} catch(InsufficientDataException e) {
			System.out.println("Erro na hora de leitura da String fornecida");
		} catch(IOException e) {
			System.out.println("Erro de conexão");
		} catch(InvalidKeyException e) {
			System.out.println("Chave secreta ou de acesso invalidas");
		} catch(NoResponseException e) {
			System.out.println("Sem resposta do servidor");
		} catch(ErrorResponseException e) {
			System.out.println("Execução mal sucessida");
		} catch(InternalException e) {
			System.out.println("Erro interno de biblioteca");
		} catch(org.xmlpull.v1.XmlPullParserException e) {
			System.out.println("Erro no arquivo de xml");
		} return null;
	}
}
