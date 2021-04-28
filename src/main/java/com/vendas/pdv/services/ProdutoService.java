package com.vendas.pdv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.pdv.domain.Categoria;
import com.vendas.pdv.domain.Produto;
import com.vendas.pdv.repositories.ProdutoRepository;
import com.vendas.pdv.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	//declarar uma dependência de um objeto repository -> Essa dependencia será automaticamente instancia dependência ou inversão de controle
	@Autowired
	private ProdutoRepository repo;
	
	//Recebe um parâmetro como ID
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
