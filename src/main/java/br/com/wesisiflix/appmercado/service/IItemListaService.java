package br.com.wesisiflix.appmercado.service;

import br.com.wesisiflix.appmercado.model.ItemLista;

public interface IItemListaService {
	public ItemLista inserirItem(ItemLista novo);
	public ItemLista alterarItem(ItemLista item);
	public void removerItem(Integer numSeq);
}
