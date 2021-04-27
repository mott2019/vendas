package com.vendas.pdv;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vendas.pdv.domain.Categoria;
import com.vendas.pdv.repositories.CategoriaRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriarepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	//ComandLineRuner -> permite implementar metodos quando a aplicação iniciar
	@Override
	public void run(String... args) throws Exception {
		
		//Instanciar os objetos da instância preparadaO
		Categoria cat1 = new Categoria(null, "Infomática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		
		//Salvar os objetos
		
		
		//cat1
		//cat2
		
		//p1
		//p2
		//p3
		
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
