package br.com.wesisiflix.appmercado.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.wesisiflix.appmercado.model.Lista;

public interface ListaDAO extends CrudRepository<Lista, Integer> {
	
}
