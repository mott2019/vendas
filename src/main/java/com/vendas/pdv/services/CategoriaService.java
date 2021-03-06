package com.vendas.pdv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vendas.pdv.domain.Categoria;
import com.vendas.pdv.repositories.CategoriaRepository;
import com.vendas.pdv.services.exception.ObjectNotFoundException;



@Service
public class CategoriaService {

	// declarar uma dependência de um objeto repository -> Essa dependencia será
	// automaticamente instancia dependência ou inversão de controle
	@Autowired
	private CategoriaRepository repo;

	// Recebe um parâmetro como ID
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new com.vendas.pdv.services.exception.DataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos");
		}
		
		
	}
}
