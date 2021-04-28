package com.vendas.pdv;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vendas.pdv.domain.Categoria;
import com.vendas.pdv.domain.Cidade;
import com.vendas.pdv.domain.Cliente;
import com.vendas.pdv.domain.Endereco;
import com.vendas.pdv.domain.Estado;
import com.vendas.pdv.domain.Produto;
import com.vendas.pdv.domain.enums.TipoCliente;
import com.vendas.pdv.repositories.CategoriaRepository;
import com.vendas.pdv.repositories.CidadeRepository;
import com.vendas.pdv.repositories.ClienteRepository;
import com.vendas.pdv.repositories.EnderecoRepository;
import com.vendas.pdv.repositories.EstadoRepository;
import com.vendas.pdv.repositories.ProdutoRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
	/*
		ComandLineRuner -> permite implementar metodos quando a aplicação iniciar
	*/	
	@Override
	public void run(String... args) throws Exception {
		
		//Instanciar os objetos da instância preparadaO
		Categoria cat1 = new Categoria(null, "Infomática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//p1
		Produto p1 = new Produto(null, "Computador", 2000.00);
		//p2
		Produto p2 = new Produto(null, "Impressora", 800.00);
		//p3
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//Conhecer as categorias dos produtos
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//Conhecer as produtos da categoria 
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c1,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93839383"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		
		
		//ip1
		//ip2
		//ip3
		
		//ped1
		//ped2
		
		//pagto1
		//pagto2
		
		//cli1
		
		//t1
		//t2
		
		//e1
		//e2
		
		//est1
		//est2
		
		//c1
		//c2
		//c3
	}

	
	
}
