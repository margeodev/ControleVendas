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
import utils.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	private Produto produtoSelecionado;
	private ProdutoFilter filtro;	
	private List<Produto> produtosFiltrados;
	
	public PesquisaProdutosBean(){
		filtro = new ProdutoFilter();
		produtosFiltrados = new ArrayList<Produto>();
	}
	
	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	public void excluir(){
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		FacesUtil.addInfoMessage("Produto "+produtoSelecionado.getSku()+" excluído com sucesso.");
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

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
				
}
