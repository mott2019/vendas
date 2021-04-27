package com.vendas.pdv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.pdv.domain.Categoria;
import com.vendas.pdv.services.CategoriaService;

// Colocar anotação para o Springboot 
// Acrescentar o Id na categoria
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	// Instancia o serviço
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { // Para que ele possa receber o id é preciso desse PathVariable, para sofsticar o metodo, ele trocou ReposonseEntity da lista, ele é um tipo especial, encapsula, armazena uma resposta HTTP para um serviço Rest
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}


//
//
//
//
//
//
//
