package com.diego.spring;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.spring.domain.Categoria;
import com.diego.spring.domain.Cidade;
import com.diego.spring.domain.Cliente;
import com.diego.spring.domain.Endereco;
import com.diego.spring.domain.Estado;
import com.diego.spring.domain.ItemPedido;
import com.diego.spring.domain.Pagamento;
import com.diego.spring.domain.PagamentoComBoleto;
import com.diego.spring.domain.PagamentoComCartao;
import com.diego.spring.domain.Pedido;
import com.diego.spring.domain.Produto;
import com.diego.spring.domain.enums.EstadoPagamento;
import com.diego.spring.domain.enums.TipoCliente;
import com.diego.spring.repositories.CategoriaRepository;
import com.diego.spring.repositories.CidadeRepository;
import com.diego.spring.repositories.ClienteRepository;
import com.diego.spring.repositories.EnderecoRepository;
import com.diego.spring.repositories.EstadoRepository;
import com.diego.spring.repositories.ItemPedidoRepository;
import com.diego.spring.repositories.PagamentoRepository;
import com.diego.spring.repositories.PedidoRepository;
import com.diego.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
