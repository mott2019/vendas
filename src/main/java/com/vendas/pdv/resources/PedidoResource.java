package com.vendas.pdv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.pdv.domain.Pedido;
import com.vendas.pdv.services.PedidoService;

// Colocar anotação para o Springboot 
// Acrescentar o Id na categoria
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	// Instancia o serviço
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { // Para que ele possa receber o id é preciso desse PathVariable, para sofsticar o metodo, ele trocou ReposonseEntity da lista, ele é um tipo especial, encapsula, armazena uma resposta HTTP para um serviço Rest
		Pedido obj = service.find(id);
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
