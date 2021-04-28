package com.vendas.pdv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// Para criar a tabela do banco de dados é necessário fazer o mapeamento. 

@Entity //Javax -> Entidade no banco de dados.
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	//serializable -> Os objetos dela, podem ser convertidos em uma sequencia de bytes. 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // geração da identificação do objeto no banco de dados
	private Integer id;
	private String nome;
	
	// associações	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
		
	// construtor vazio padrão java
	public Categoria() {
		
	}

	// Construction use fields
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	// Getters e Setters - Methodos de acesso.
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	//hashCode e equalds -> São necessários para fazer o comparativo de valor dos objetos - Considera várias opções de comparação.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
