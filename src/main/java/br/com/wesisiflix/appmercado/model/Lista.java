package br.com.wesisiflix.appmercado.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lista")
public class Lista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista")
	private Integer id;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDate date;
	
	@Column(name = "nome_mercado", length = 50)
	private String nomeMercado;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	@Column(name = "status")
	private Integer status;
	
	@OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
	private List<ItemLista> itens;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getNomeMercado() {
		return nomeMercado;
	}
	public void setNomeMercado(String nomeMercado) {
		this.nomeMercado = nomeMercado;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<ItemLista> getItens() {
		return itens;
	}
	public void setItens(List<ItemLista> itens) {
		this.itens = itens;
	}
	
}
