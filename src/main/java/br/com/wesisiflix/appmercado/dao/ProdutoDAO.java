package br.com.wesisiflix.appmercado.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.wesisiflix.appmercado.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer>{
	public List<Produto> findAllByNomeContaining(String palavraChave);
}
