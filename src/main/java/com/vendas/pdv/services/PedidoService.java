package com.vendas.pdv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.pdv.domain.Pedido;
import com.vendas.pdv.repositories.PedidoRepository;
import com.vendas.pdv.services.exception.ObjectNotFoundException;



@Service
public class PedidoService {

	// declarar uma dependência de um objeto repository -> Essa dependencia será
	// automaticamente instancia dependência ou inversão de controle
	@Autowired
	private PedidoRepository repo;

	// Recebe um parâmetro como ID
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
