package br.com.wesisiflix.appmercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wesisiflix.appmercado.dao.ItemListaDAO;
import br.com.wesisiflix.appmercado.model.ItemLista;

@Component
public class ItemListaServiceImpl implements IItemListaService {
	
	@Autowired
	private ItemListaDAO repo;

	@Override
	public ItemLista inserirItem(ItemLista novo) {
		// TODO Auto-generated method stub
		return repo.save(novo);
	}

	@Override
	public ItemLista alterarItem(ItemLista item) { // vem com chave primaria, o save entende como update
		// TODO Auto-generated method stub
		return repo.save(item);
	}

	@Override
	public void removerItem(Integer numSeq) {
		// TODO Auto-generated method stub
		repo.deleteById(numSeq);
	}

}
