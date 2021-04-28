package com.vendas.pdv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.pdv.domain.Produto;
import com.vendas.pdv.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	//declarar uma dependência de um objeto repository -> Essa dependencia será automaticamente instancia dependência ou inversão de controle
	@Autowired
	private ProdutoRepository repo;
	
	//Recebe um parâmetro como ID
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
