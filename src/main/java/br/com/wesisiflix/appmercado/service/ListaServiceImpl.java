package br.com.wesisiflix.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wesisiflix.appmercado.dao.ListaDAO;
import br.com.wesisiflix.appmercado.model.ItemLista;
import br.com.wesisiflix.appmercado.model.Lista;

@Component
public class ListaServiceImpl implements IListaService{
	
	@Autowired
	private ListaDAO repo;

	@Override
	public Lista criarNovaLista(Lista nova) {
		// TODO Auto-generated method stub
		return repo.save(nova);
	}

	@Override
	public void removerLista(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Lista fecharLista(Integer id) {
		// TODO Auto-generated method stub
		Lista l = repo.findById(id).get();
		double total = 0.0;
		for(ItemLista item : l.getItens()) {
			total += l.getValorTotal();
		}
		l.setValorTotal(total);
		l.setStatus(1);
		return repo.save(l);
	}

	@Override
	public Lista buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Lista> buscarTodas() {
		// TODO Auto-generated method stub
		return (List<Lista>) repo.findAll();
	}

}
