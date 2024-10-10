package br.com.wesisiflix.appmercado.service;

import java.util.List;

import br.com.wesisiflix.appmercado.model.Produto;

public interface IProdutoService {
	public Produto criarNovoProduto(Produto prod);
	public List<Produto> listarTodos();
	public List<Produto> buscarPorPalavraChave(String key);	
	public Produto buscarPorId(Integer id);
}
