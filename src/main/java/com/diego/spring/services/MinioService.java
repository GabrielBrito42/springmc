package com.diego.spring.services;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.NoResponseException;
import io.minio.errors.RegionConflictException;

@Service
public class MinioService {

	@Autowired
	private MinioClient minioClient;
	
	public void uploadFile(String localFilePath) throws RegionConflictException  {
		try {
				minioClient.putObject("springmc", "sinon.jpg", localFilePath);
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
		}
	}
}
