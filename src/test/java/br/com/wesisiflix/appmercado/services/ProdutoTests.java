package br.com.wesisiflix.appmercado.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wesisiflix.appmercado.dao.ProdutoDAO;
import br.com.wesisiflix.appmercado.model.Produto;
import br.com.wesisiflix.appmercado.service.ProdutoServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTests {
	
	@InjectMocks
	private ProdutoServiceImpl service;
	
	@Mock
	private ProdutoDAO repo;
	
	private Integer existingId = 1;
	private Integer nonExistentId = 100;
	private String keyword = "bolacha";
	private Produto newProd;
	private Produto createdProd;
	private ArrayList<Produto> listaDeVariosProdutos;
	
	@BeforeEach
	public void setup() throws Exception {
		newProd = new Produto();
		newProd.setNome("Bolacha");
		
		createdProd = new Produto();
		createdProd.setId(1);
		createdProd.setNome("Bolacha");
		
		listaDeVariosProdutos = new ArrayList<Produto>();
		Produto p1, p2;
		p1 = new Produto();
		p1.setId(2);
		p1.setNome("Bolacha recheada");
		p2 = new Produto();
		p2.setId(3);
		p2.setNome("Bolacha água e sal");
		listaDeVariosProdutos.add(p1);
		listaDeVariosProdutos.add(p2);
		
		Mockito.when(repo.save(newProd)).thenReturn(createdProd);
		Mockito.when(repo.findById(existingId)).thenReturn(Optional.of(createdProd));
		Mockito.when(repo.findById(nonExistentId)).thenReturn(Optional.ofNullable(null));
		Mockito.when(repo.findAllByNomeContaining("Biscoito")).thenReturn(new ArrayList<Produto>());
		Mockito.when(repo.findAllByNomeContaining(keyword)).thenReturn(listaDeVariosProdutos);
	}

	@Test
	public void deveriaCadastrarProduto() {
		assertEquals(service.criarNovoProduto(newProd), createdProd); 
	}
	
	@Test
	public void deveriaRetornarPeloId() {
		assertNotNull(service.buscarPorId(existingId));
	}
	
	@Test
	public void deveriaNaoEncontrarId() {
		assertNull(service.buscarPorId(nonExistentId));
	}
	
	@Test
	public void deveriaRetornarListaComPalavraChave() {
		assertTrue(service.buscarPorPalavraChave(keyword).size() > 0);
	}
	
	@Test
	public void deveriaRetornarListaVazia() {
		assertTrue(service.buscarPorPalavraChave("Biscoito").size() == 0);
	}
	
	
}
