package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import filter.ProdutoFilter;
import model.Produto;
import repository.Produtos;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	private ProdutoFilter filtro;	
	private List<Produto> produtosFiltrados;
	
	public PesquisaProdutosBean(){
		filtro = new ProdutoFilter();
		produtosFiltrados = new ArrayList<Produto>();
	}
	
	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	public List<Produto> getProdutosFiltrados(){
		return produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ProdutoFilter filtro) {
		this.filtro = filtro;
	}
		
}
