package com.vendas.pdv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.pdv.domain.Categoria;
import com.vendas.pdv.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	//declarar uma dependência de um objeto repository -> Essa dependencia será automaticamente instancia dependência ou inversão de controle
	@Autowired
	private CategoriaRepository repo;
	
	//Recebe um parâmetro como ID
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}