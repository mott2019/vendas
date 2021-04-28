package com.vendas.pdv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.pdv.domain.Cliente;
import com.vendas.pdv.repositories.ClienteRepository;
import com.vendas.pdv.services.exception.ObjectNotFoundException;



@Service
public class ClienteService {

	// declarar uma dependência de um objeto repository -> Essa dependencia será
	// automaticamente instancia dependência ou inversão de controle
	@Autowired
	private ClienteRepository repo;

	// Recebe um parâmetro como ID
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
