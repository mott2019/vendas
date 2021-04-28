package com.vendas.pdv;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vendas.pdv.domain.Categoria;
import com.vendas.pdv.domain.Produto;
import com.vendas.pdv.repositories.CategoriaRepository;
import com.vendas.pdv.repositories.ProdutoRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
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
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
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
