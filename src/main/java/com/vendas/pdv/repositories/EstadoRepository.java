package com.vendas.pdv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendas.pdv.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	//Este acessa Dados
}
